/**
 *
 * @author Quan Duc Loc CE140037 SE1401
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
 * Class implementation from interface IAuthentication
 *
 */
public class Authentication extends UnicastRemoteObject implements IAuthentication {

    // constructor
    public Authentication() throws RemoteException {
        super();

        // register the JDBC driver
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Authentication.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /* Override and define abstract methods */
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
     * @return 0 if operation successful, 1 if unsuccessful
     * @throws RemoteException
     */
    @Override
    public int createUser(String username, String password, String fullname, String gender, String email, String phone, String address) throws RemoteException {
        boolean error = false; // check if there's any errors occured

        // add user info to database
        try {
            // connect to database
            Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=Ewallet", "sa", "123");
            PreparedStatement st = conn.prepareStatement("Insert into user values(?, ?, ?, ?, ?, ?, ?)");

            // set values in the statement
            st.setString(1, username);
            st.setString(2, password);
            st.setString(3, fullname);
            st.setString(4, address);
            st.setString(5, phone);
            st.setString(6, email);
            st.setString(7, gender);

            // execute update (insert)
            int count = st.executeUpdate();
            System.out.println(count);
        } catch (SQLException ex) {
            System.out.println("An SQL Error Occured!");
            error = true; // if any errors occured
        }

        // return 0 if there are no errors (successful operation), else return 1 (unsuccessful)
        if (!error) {
            return 0;
        } else {
            return 1;
        }
    }

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
            Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=Ewallet", "sa", "123456");

            // statement to retrieve all users with such inputted username and password 
            PreparedStatement st = conn.prepareStatement("Select * from users where username = ? and password = ?");

            // set the values in the statement
            st.setString(1, username);
            st.setString(2, hashPassword);

            ResultSet rs = st.executeQuery();

            // if there is a user found, return 0 (successful operation)
            if (rs.next()) {
                PreparedStatement getRole = conn.prepareStatement("SELECT * FROM user_role JOIN user_money ON user_role.user_id = user_money.id WHERE user_role.user_id = ? ");
                getRole.setString(1, rs.getString("id"));
                ResultSet rsRole = getRole.executeQuery();
                if (rsRole.next()) {
                    
                    User user = new User(rs.getString("id"), rs.getString("username"), rs.getString("fullname"), rs.getString("address"), rs.getString("phone"), rs.getString("mail"), rs.getString("gender"), rsRole.getString("role_id"),rsRole.getString("total_money"));
                    return user;
                } else {
                    System.out.println("meos cos gii");
                    return null;
                }
                // if there is no user found, return 2 (successful operation but, login failed)
            } else {
                return null;
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            error = true; // if any errors occured
            return null;

        }

    }

}
