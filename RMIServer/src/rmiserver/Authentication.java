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

/**
 * Class implementation from interface IAuthentication
 * @author Admin
 */
public class Authentication extends UnicastRemoteObject implements IAuthentication {

    // constructor
    public Authentication() throws RemoteException {
        super();
    }

    /* Override and define abstract methods */
    
    /**
     * create user and store into database
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
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/se1401", "root", "");
            PreparedStatement st = conn.prepareStatement("Insert into user values(?, ?, ?, ?, ?, ?, ?)");

            // set values in the statement
            st.setString(1, username);
            st.setString(2, password);
            st.setString(3, email);
            st.setString(4, address);
            st.setString(5, gender);
            st.setString(6, fullname);
            st.setString(7, phone);
            
            // execute statement
            st.executeUpdate();
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
     * @param username
     * @param password
     * @return 0 if operation successful, 1 or 2 if unsuccessful
     * @throws RemoteException 
     */
    @Override
    public int validateUser(String username, String password) throws RemoteException{
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
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/se1401", "root", "");
            PreparedStatement st = conn.prepareStatement("Select * from user where Username = BINARY ? and Password = BINARY ?");

            // set the values in the statement
            st.setString(1, username);
            st.setString(2, hashPassword);

            ResultSet rs = st.executeQuery();

            // if there is a user found, return 0 (successful operation)
            if (rs.next()) {
                return 0;
            // if there is no user found, return 2 (successful operation but, login failed)
            } else {
                return 2;
            }

        } catch (SQLException ex) {
            System.out.println("An SQL Error Occured!");
            error = true; // if any errors occured
        }

        // if there are no errors, return 0 (successful operation), else return 1 (unsuccessful)
        if (!error) {
            return 0;
        } else {
            return 1;
        }
    }

}
