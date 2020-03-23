
/**
 * 
 * @author Wibuu Group, consists of 3 members:
 * @author Nguyen Duc Tong
 * @author Quan Duc Loc
 * @author Tran Minh Thang
 * 
 */
package rmiserver;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserFunc extends UnicastRemoteObject implements IUserFunc {
    
    // constructor
    public UserFunc() throws RemoteException {
        super();

        // register the JDBC driver
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
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
     * @return 0 if operation successful, 1 if unsuccessful, 2 if phone number is duplicated
     * @throws RemoteException
     */
    @Override
    public int createUser(String username, String password, String fullname, String gender, String email, String phone, String address) throws RemoteException {
        boolean error = false; // check if there's any errors occured

        // add user info to database
        try {
            // connect to database
            Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=Ewallet", "sa", "123");
            PreparedStatement st = conn.prepareStatement("SELECT * FROM users WHERE phone = " + phone);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return 2; // indicate that phone number already bound to another account in database
            }

            /* Add new user to database */
            st = conn.prepareStatement("Insert into users (username, password, fullname, address, phone, mail, gender)"
                    + " values(?, ?, ?, ?, ?, ?, ?)");

            // set values in the statement
            st.setString(1, username);
            st.setString(2, password);
            st.setString(3, fullname);
            st.setString(4, address);
            st.setString(5, phone);
            st.setString(6, email);
            st.setString(7, gender);

            // execute update (insert)
            st.executeUpdate();

            /* Get user ID from database to add data to other tables */
            st = conn.prepareStatement("SELECT id FROM users WHERE phone = " + phone);

            rs = st.executeQuery();
            rs.next();

            int userID = rs.getInt(1); // store the user ID of the user (who has just been added to database above)

            // execute SQL statements
            st = conn.prepareStatement("INSERT INTO user_role(user_id, role_id) VALUES(" + userID + ", 2)");
            st.executeUpdate();
            st = conn.prepareStatement("INSERT INTO user_money(user_id, total_money) VALUES(" + userID + ", " + 0 + ")");
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

    @Override
    public int deposit() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    public int payTuition() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int viewTransactionHistory() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
