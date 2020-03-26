/**
 *
 * @author Wibuu Group, consists of 3 members:
 * @author Nguyen Duc Tong
 * @author Quan Duc Loc
 * @author Tran Minh Thang
 *
 */
package rmiserver;

import java.math.BigInteger;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AdminFunc extends UnicastRemoteObject implements IAdminFunc {

    Connection conn; // connection to database

    /* Constructor */
    public AdminFunc(Connection conn) throws RemoteException {
        super();

        // Register the JDBC Driver
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            this.conn = conn; // setup the connection to database
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AdminFunc.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /* Override methods in IAdminFunc interface */
    
    /**
     * create user and store into database
     *
     * @param username
     * @param password
     * @param fullname
     * @param gender
     * @param email
     * @param phone
     * @param address
     * @param role
     * @return 0 (operation successful), 1 (SQL Exception occurred), 2 (phone number already exists), 3 (username already exists), 4 (encrypt password error)
     * @throws RemoteException
     */
    @Override
    public int createUser(String username, String password, String fullname, String gender, String email, String phone, String address, int role) throws RemoteException {
        /* Add user info to database */
        try {

            /* Check if phone number already exists in database */
            PreparedStatement stCheckPhone = conn.prepareStatement("SELECT * FROM users WHERE phone = ?");
            stCheckPhone.setString(1, phone);
            ResultSet rsCheckPhone = stCheckPhone.executeQuery();

            /* Check if username already exists in database */
            PreparedStatement stCheckUsername = conn.prepareStatement("SELECT * FROM users WHERE username = ?");
            stCheckUsername.setString(1, username);
            ResultSet rsCheckUsername = stCheckUsername.executeQuery();

            if (rsCheckPhone.next()) {
                return 2; // indicate that phone number already bound to another account in database
            } else if (rsCheckUsername.next()) {
                return 3; // indicate that username already bound to another account in database
            }

            String hashPassword = ""; // store MD5 hashed version of password

            /* Code to hash password using MD5 algorithm */
            try {
                MessageDigest md = MessageDigest.getInstance("MD5");

                byte[] messageDigest = md.digest(password.getBytes());

                BigInteger no = new BigInteger(1, messageDigest);

                // Convert message digest into hex value
                hashPassword = no.toString(16);
                while (hashPassword.length() < 32) {
                    hashPassword = "0" + hashPassword;
                }
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(AdminFunc.class.getName()).log(Level.SEVERE, null, ex);
                return 4; // indicate encrypt password error
            }

            /* Execute SQL to add new user to database */
            PreparedStatement stCreateUser = conn.prepareStatement("Insert into users (username, password, fullname, address, phone, mail, gender, status)"
                    + " values(?, ?, ?, ?, ?, ?, ?, ?)");

            /* Set values in SQL statement */
            stCreateUser.setString(1, username);
            stCreateUser.setString(2, hashPassword);
            stCreateUser.setString(3, fullname);
            stCreateUser.setString(4, address);
            stCreateUser.setString(5, phone);
            stCreateUser.setString(6, email);
            stCreateUser.setString(7, gender);
            stCreateUser.setInt(8, 1);

            stCreateUser.executeUpdate();

            /* Get user ID from database to add data to other tables */
            PreparedStatement stGetUserID = conn.prepareStatement("SELECT id FROM users WHERE phone = ?");
            stGetUserID.setString(1, phone);

            ResultSet rsUserID = stGetUserID.executeQuery();
            rsUserID.next();

            int userID = rsUserID.getInt("id"); // store the user ID of the user (who has just been added to database above)

            /* Adding data to other 2 tables */
            PreparedStatement stSetRoleID = conn.prepareStatement("INSERT INTO user_role(user_id, role_id) VALUES(? , ?)");
            stSetRoleID.setInt(1, userID);
            stSetRoleID.setInt(2, role);

            stSetRoleID.executeUpdate();

            PreparedStatement stSetMoney = conn.prepareStatement("INSERT INTO user_money(user_id, total_money) VALUES(?, ?)");
            stSetMoney.setInt(1, userID);
            stSetMoney.setInt(2, 0);
            stSetMoney.executeUpdate();
            
            return 0; // operation successful
        } catch (SQLException ex) {
            Logger.getLogger(AdminFunc.class.getName()).log(Level.SEVERE, null, ex);
            return 1; // indicate SQL Exception
        }
    }

    @Override
    public User getUser(String phone) {
        try {
            /* Get user with passed phone number */
            PreparedStatement st = conn.prepareStatement("Select * from users where phone = ?");
            st.setString(1, phone);
            ResultSet rs = st.executeQuery();

            // if such user exists
            if (rs.next()) {
                /* Get user role ID from database */
                PreparedStatement getRole = conn.prepareStatement("SELECT * FROM user_role JOIN user_money ON user_role.user_id = user_money.user_id WHERE user_role.user_id = ? ");
                getRole.setString(1, rs.getString("id"));
                ResultSet rsRole = getRole.executeQuery();

                // if user role also exists
                if (rsRole.next()) {
                    /* Get transaction limits from database */
                    PreparedStatement getLim = conn.prepareStatement("SELECT * FROM setting");
                    ResultSet rsLim = getLim.executeQuery();
                    rsLim.next();

                    return new User(rs.getString("id"), rs.getString("username"), rs.getString("fullname"), rs.getString("phone"), rs.getString("mail"), rs.getString("address"), rs.getString("gender"), rsRole.getString("role_id"), rsRole.getString("total_money"), rsLim.getString("deposit_lim"), rsLim.getString("withdraw_lim"), rsLim.getString("trans_lim"));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminFunc.class.getName()).log(Level.SEVERE, null, ex);
            return new User(); // indicate SQL error occured
        }

        return null; // user does not exist
    }

    @Override
    public boolean changePassword(String id, String password) {
        String hashPassword = ""; // store password that is MD5 hashed version of user's password (for validation)

        /* code to hash password using MD5 algorithm */
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");

            byte[] messageDigest = md.digest(password.getBytes());

            BigInteger no = new BigInteger(1, messageDigest);

            // Convert message digest into hex value
            hashPassword = no.toString(16);
            while (hashPassword.length() < 32) {
                hashPassword = "0" + hashPassword;
            }
        } catch (NoSuchAlgorithmException e) {
            System.out.println("Hashing password error while validating!");
        }
        try {
            PreparedStatement st = conn.prepareStatement("UPDATE users SET password = ? WHERE id=?");
            st.setString(1, hashPassword);
            st.setString(2, id);
            int rs = st.executeUpdate();
            if (rs > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminFunc.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }

    @Override
    public boolean suspendUser(int id) {
        try {
            PreparedStatement st = conn.prepareStatement("UPDATE users SET status = 0 WHERE id=?");
            st.setInt(1, id);
            int rs = st.executeUpdate();
            if (rs > 0) {
                return true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(AdminFunc.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }

    /**
     *
     * @param type
     * @return
     */
    @Override
    public ArrayList<ReportList> getReportAll(String type) {
        try {
            ArrayList<ReportList> rp = new ArrayList<>();
            int itype = 0;
            String money;
            String stm;
            if (type.equals("user_withdraw")) {
                stm = "SELECT * FROM user_withdraw WHERE type= 1 ORDER BY created_at DESC";

            } else if (type.equals("user_deposit")) {
                stm = "SELECT * FROM user_deposit WHERE type= 0 ORDER BY created_at DESC";
            } else {
                stm = "SELECT * FROM user_transfer WHERE type= 2 ORDER BY created_at DESC";
            }
            PreparedStatement st = conn.prepareStatement(stm);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                ReportList newrp;
                if (type.equals("user_withdraw") || type.equals("user_deposit")) {
                    newrp = new ReportList(rs.getString("id"), rs.getString("money"), rs.getString("type"), rs.getString("created_at"), rs.getString("user_id"), "", rs.getString("description") == null ? "" : rs.getString("description"));
                } else {
                    newrp = new ReportList(rs.getString("id"), rs.getString("money"), rs.getString("type"), rs.getString("created_at"), rs.getString("send_id"), rs.getString("receive_id"), "");
                }
                rp.add(newrp);
            }

            return rp;
        } catch (SQLException ex) {
            Logger.getLogger(AdminFunc.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }
}
