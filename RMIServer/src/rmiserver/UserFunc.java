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
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserFunc extends UnicastRemoteObject implements IUserFunc {

    Connection conn;

    // constructor
    public UserFunc(Connection conn) throws RemoteException {
        super();

        // register the JDBC driver
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            this.conn = conn;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Authentication.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /* Override methods in IUserFunc interface */
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
     * @return 0 if operation successful, 1 if unsuccessful, 2 if phone number
     * is duplicated
     * @throws RemoteException
     */
    @Override
    public int createUser(String username, String password, String fullname, String gender, String email, String phone, String address) throws RemoteException {
        boolean error = false; // check if there's any errors occured

        // add user info to database
        try {
            // connect to database
            Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=Ewallet", "sa", "123456");

            /* Check if phone number already exists in database */
            PreparedStatement st = conn.prepareStatement("SELECT * FROM users WHERE phone = " + phone);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return 2; // indicate that phone number already bound to another account in database
            }

            String hashPassword = ""; // store MD5 hashed version of password

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
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(Authentication.class.getName()).log(Level.SEVERE, null, ex);
                error = true;
            }

            /* Add new user to database */
            st = conn.prepareStatement("Insert into users (username, password, fullname, address, phone, mail, gender, status)"
                    + " values(?, ?, ?, ?, ?, ?, ?, ?)");

            // set values in the statement
            st.setString(1, username);
            st.setString(2, hashPassword);
            st.setString(3, fullname);
            st.setString(4, address);
            st.setString(5, phone);
            st.setString(6, email);
            st.setString(7, gender);
            st.setInt(8, 1);

            st.executeUpdate();

            /* Get user ID from database to add data to other tables */
            st = conn.prepareStatement("SELECT id FROM users WHERE phone = ?");
            st.setString(1, phone);

            rs = st.executeQuery();
            rs.next();

            int userID = rs.getInt(1); // store the user ID of the user (who has just been added to database above)

            // execute SQL statements to complete creating new user
            st = conn.prepareStatement("INSERT INTO user_role(user_id, role_id) VALUES(? , 2)");
            st.setInt(1, userID);
            st.executeUpdate();
            st = conn.prepareStatement("INSERT INTO user_money(user_id, total_money) VALUES(?, ?)");
            st.setInt(1, userID);
            st.setInt(2, 0);
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Authentication.class.getName()).log(Level.SEVERE, null, ex);
            error = true; // if any errors occured
        }

        // return 0 if there are no errors (successful operation), else return 1 (unsuccessful)
        if (!error) {
            return 0;
        } else {
            return 1;
        }
    }

    @Override
    public User deposit(User oldUserInfo, int depositAmount) throws RemoteException {
        boolean error = false; // check if there's any errors occured
        User newUserInfo = oldUserInfo;

        // add user info to database
        try {
            // connect to database
            Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=Ewallet", "sa", "123456");
            PreparedStatement st = conn.prepareStatement("SELECT * FROM setting");
            ResultSet rs = st.executeQuery();
            rs.next();

            int maxDepositLimit = rs.getInt(1); // maximum deposit amount in 1 day
            int totalDeposit = -1; // total deposit amount in current day
            String currentTime = java.time.LocalDate.now().toString();

            /* get the total deposit amount in current day */
            st = conn.prepareStatement("SELECT SUM(deposit_money) FROM user_deposit WHERE user_id = ? AND created_at LIKE '?'");

            rs = st.executeQuery();

            st.setInt(1, newUserInfo.getId());
            st.setString(2, currentTime);

            rs.next();
            totalDeposit = rs.getInt(1);

            if (depositAmount > maxDepositLimit || totalDeposit + depositAmount > maxDepositLimit) {
                oldUserInfo.setDeposit_lim(totalDeposit);
                return oldUserInfo;
            } else {
                st = conn.prepareStatement("INSERT INTO user_deposit(user_id, deposit_money, created_at, type) VALUES(?, ?, ?, ?)");
                st.setInt(1, newUserInfo.getId());
                st.setInt(2, depositAmount);
                st.setString(3, currentTime);
                st.setInt(4, 0);
                st.executeUpdate();

                st = conn.prepareStatement("UPDATE user_money SET total_money = ? WHERE user_id = ?");
                st.setInt(1, depositAmount + newUserInfo.getMoney());
                st.setInt(2, newUserInfo.getId());
                st.executeUpdate();
            }

        } catch (SQLException ex) {
            Logger.getLogger(Authentication.class.getName()).log(Level.SEVERE, null, ex);
            error = true; // if any errors occured
        }

        // return 0 if there are no errors (successful operation), else return 1 (unsuccessful)
        if (!error) {
            newUserInfo.setMoney(depositAmount + newUserInfo.getMoney());
            return newUserInfo;
        } else {
            return oldUserInfo;
        }
    }

    @Override
    public int withdraw() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int transfer() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int changeInfo() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int deleteAccount() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int viewTransactionHistory() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Map<String, String> getSchool() throws RemoteException {
        Map<String, String> schoolname = new HashMap<>();
        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=Ewallet", "sa", "sa@123");
            PreparedStatement st = conn.prepareStatement("select id, name from universities");
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                schoolname.put(rs.getString("id"), rs.getString("name"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserFunc.class.getName()).log(Level.SEVERE, null, ex);
        }
        return schoolname;
    }

    @Override
    public String getTuition(String schoolId, String studentId) throws RemoteException {
        String tuitionInfo = "";
        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=Ewallet", "sa", "sa@123");
            PreparedStatement st = conn.prepareStatement("select tuition.name, tuition.tuition from dbo.tuition where tuition.id_student like ? and tuition.id_uni = ? ");
            st.setString(1, studentId);
            st.setString(2, schoolId );
            ResultSet rs = st.executeQuery();
            while(rs.next()){
               tuitionInfo = rs.getString("name") + ": " + rs.getString("tuition");
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserFunc.class.getName()).log(Level.SEVERE, null, ex);
        }

        return tuitionInfo;
    }

    @Override
    public boolean payTuition(String schoolId, String studentId) throws RemoteException {
        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=Ewallet", "sa", "sa@123");
            PreparedStatement st = conn.prepareStatement("update dbo.tuition set tuition.tuition = 0 where tuition.id_student like ? and tuition.id_uni = ? ");
            st.setString(1, studentId);
            st.setString(2, schoolId );
            int count = st.executeUpdate();
            if(count > 0){
                return true;
            }else{
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserFunc.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
