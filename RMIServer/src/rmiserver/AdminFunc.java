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
import java.util.logging.Level;
import java.util.logging.Logger;

public class AdminFunc extends UnicastRemoteObject implements IAdminFunc {

    Connection conn;

    // constructor
    public AdminFunc(Connection conn) throws RemoteException {
        super();

        // register the JDBC driver
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            this.conn = conn;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Authentication.class.getName()).log(Level.SEVERE, null, ex);
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
    public boolean changePassword(String id, String password
    ) {
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
    public boolean suspendUser(String id) {
        try {
            PreparedStatement st = conn.prepareStatement("UPDATE users SET status = 0 WHERE id=?");
            st.setString(1, id);
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
    public ReportList getReportAll(String type) {
        try {
            ReportList rp;
            int itype = 0;
            String money;
            String stm;
            if (type.equals("user_withdraw")) {
                stm = "SELECT * FROM user_withdraw WHERE type= 1 ORDER BY created_at DESC";

            } else if (type.equals("user_deposit")) {
                stm = "SELECT * FROM user_deposit WHERE type= 0 ORDER BY created_at DESC";
                System.out.println(stm);
            } else {
                stm = "";
            }
            PreparedStatement st = conn.prepareStatement(stm);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                rp = new ReportList(rs.getString("id"), rs.getString("money"), rs.getString("type"), rs.getString("created_at"), "", "", rs.getString("description"));
                return rp;

            }

        } catch (SQLException ex) {
            Logger.getLogger(AdminFunc.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    /* Override methods in IAdminFunc interface */
}
