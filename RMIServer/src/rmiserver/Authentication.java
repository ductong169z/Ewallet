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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class implementation from interfaces IAuthentication, IUserFunc, IAdminFunc
 *
 */
public class Authentication extends UnicastRemoteObject implements IAuthentication {

    Connection conn;

    // constructor
    public Authentication(Connection conn) throws RemoteException {
        super();

        // register the JDBC driver
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            this.conn = conn;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Authentication.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /* Override methods in IAuthentication interface */
    /**
     * validate user upon login process
     *
     * @param username
     * @param password
     * @return 0 if operation successful, 1 or 2 if unsuccessful
     * @throws RemoteException
     */
    @Override
    public User validateUser(String username, String password) throws RemoteException {
        boolean error = false; // check if there's any errors occured
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
            error = true; // mark that there's an error occured
        }

        try {
            // connect to database

            // statement to retrieve all users with such inputted username and password 
            PreparedStatement st = conn.prepareStatement("Select * from users where username = ? and password = ?");

            // set the values in the statement
            st.setString(1, username);
            st.setString(2, hashPassword);

            ResultSet rs = st.executeQuery();

            // if there is a user found, return 0 (successful operation)
            if (rs.next()) {
                PreparedStatement getRole = conn.prepareStatement("SELECT * FROM user_role JOIN user_money ON user_role.user_id = user_money.user_id WHERE user_role.user_id = ? ");
                getRole.setString(1, rs.getString("id"));
                ResultSet rsRole = getRole.executeQuery();

                PreparedStatement getLim = conn.prepareStatement("SELECT * FROM setting");
                ResultSet rsLim = getLim.executeQuery();

                if (rsRole.next()) {
                    rsLim.next();
                    User user = new User(rs.getString("id"), rs.getString("username"), rs.getString("fullname"), rs.getString("phone"), rs.getString("mail"), rs.getString("address"), rs.getString("gender"), rsRole.getString("role_id"), rsRole.getString("total_money"), rsLim.getString("deposit_lim"), rsLim.getString("withdraw_lim"), rsLim.getString("trans_lim"));
                    return user;
                } else {
                    return null;
                }
                // if there is no user found, return 2 (successful operation but, login failed)
            } else {
                return null;
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            error = true; // if any errors occured
            return new User();
        }

    }

    @Override
    public boolean checkStatus(String user_id) {
        try {
            PreparedStatement st = conn.prepareStatement("Select status from users where id = ? AND status =1 ");
            st.setString(1, user_id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Authentication.class.getName()).log(Level.SEVERE, null, ex);
        }
                return false;

    }
}
