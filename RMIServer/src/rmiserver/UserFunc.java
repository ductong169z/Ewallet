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
     * @return 0 if operation successful, 1 if unsuccessful, 2 if phone number is duplicated
     * @throws RemoteException
     */
    @Override
    public int createUser(String username, String password, String fullname, String gender, String email, String phone, String address) throws RemoteException {
        boolean error = false; // check if there's any errors occured

        // add user info to database
        try {

            /* Check if phone number already exists in database */
            PreparedStatement stCheckPhone = conn.prepareStatement("SELECT * FROM users WHERE phone = " + phone);

            ResultSet rsCheckPhone = stCheckPhone.executeQuery();
            if (rsCheckPhone.next()) {
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
            PreparedStatement stCreateUser = conn.prepareStatement("Insert into users (username, password, fullname, address, phone, mail, gender, status)"
                    + " values(?, ?, ?, ?, ?, ?, ?, ?)");

            // set values in the statement
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

            // execute SQL statements to complete creating new user
            PreparedStatement stSetRoleID = conn.prepareStatement("INSERT INTO user_role(user_id, role_id) VALUES(? , 2)");
            stSetRoleID.setInt(1, userID);
            stSetRoleID.executeUpdate();

            PreparedStatement stSetMoney = conn.prepareStatement("INSERT INTO user_money(user_id, total_money) VALUES(?, ?)");
            stSetMoney.setInt(1, userID);
            stSetMoney.setInt(2, 0);
            stSetMoney.executeUpdate();
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

        // try perform deposit transaction
        try {
            /* Get deposit limit from database */
            PreparedStatement stGetLim = conn.prepareStatement("SELECT * FROM setting");
            ResultSet rsGetLim = stGetLim.executeQuery();
            rsGetLim.next();

            int maxDepositLim = rsGetLim.getInt("deposit_lim"); // maximum deposit amount in 1 day
            int totalDeposit = -1; // total deposit amount in current day
            String currentTime = java.time.LocalDate.now().toString(); // current time when user perform deposit

            /* Get the total deposit amount in current day */
            PreparedStatement stGetTotal = conn.prepareStatement("SELECT SUM(money) FROM user_deposit WHERE user_id = ? AND created_at = ?");

            stGetTotal.setInt(1, newUserInfo.getId());
            stGetTotal.setString(2, currentTime);

            ResultSet rsGetTotal = stGetTotal.executeQuery();

            // if there are already some transactions of deposit performed earlier
            if (rsGetTotal.next()) {
                totalDeposit = rsGetTotal.getInt(1);
            } else {
                totalDeposit = 0;
            }

            // if total deposit already at limit
            if (totalDeposit == maxDepositLim) {
                return null;
            }

            // check if reached max deposit limit
            if (totalDeposit + depositAmount > maxDepositLim) {
                oldUserInfo.setDeposit_lim(maxDepositLim - totalDeposit); // set new deposit limit
                return oldUserInfo;
            } else {
                /* Update deposit history in database */
                PreparedStatement stCreateDeposit = conn.prepareStatement("INSERT INTO user_deposit(user_id, money, created_at, type) VALUES(?, ?, ?, ?)");
                stCreateDeposit.setInt(1, newUserInfo.getId());
                stCreateDeposit.setInt(2, depositAmount);
                stCreateDeposit.setString(3, currentTime);
                stCreateDeposit.setInt(4, 0);
                stCreateDeposit.executeUpdate();

                /* Update user money in database */
                PreparedStatement stUpdateMoney = conn.prepareStatement("UPDATE user_money SET total_money = ? WHERE user_id = ?");
                stUpdateMoney.setInt(1, depositAmount + newUserInfo.getMoney());
                stUpdateMoney.setInt(2, newUserInfo.getId());
                stUpdateMoney.executeUpdate();
            }

        } catch (SQLException ex) {
            Logger.getLogger(Authentication.class.getName()).log(Level.SEVERE, null, ex);
            error = true; // if any errors occured
        }

        // return new user info if successful, else return old one
        if (!error) {
            newUserInfo.setMoney(depositAmount + newUserInfo.getMoney()); // set new user balance
            return newUserInfo;
        } else {
            return oldUserInfo;
        }
    }

    @Override
    public User withdraw(User oldUserInfo, int withdrawAmount) throws RemoteException {
        boolean error = false; // check if there's any errors occured
        User newUserInfo = oldUserInfo;

        // try perform withdraw transaction
        try {
            /* Get max withdraw limit in database */
            PreparedStatement stGetLim = conn.prepareStatement("SELECT * FROM setting");
            ResultSet rsGetLim = stGetLim.executeQuery();
            rsGetLim.next();

            int maxWithdrawLim = rsGetLim.getInt("withdraw_lim"); // maximum withdraw amount in 1 day
            int totalWithdraw = -1; // total withdraw amount in current day
            String currentTime = java.time.LocalDate.now().toString(); // current time when user perform withdraw

            /* Get the total withdraw amount in current day */
            PreparedStatement stGetTotal = conn.prepareStatement("SELECT SUM(money) FROM user_withdraw WHERE user_id = ? AND created_at = ?");

            stGetTotal.setInt(1, newUserInfo.getId());
            stGetTotal.setString(2, currentTime);

            ResultSet rsGetTotal = stGetTotal.executeQuery();

            // if there are already some transactions of withdrawal performed earlier
            if (rsGetTotal.next()) {
                totalWithdraw = rsGetTotal.getInt(1);
            } else {
                totalWithdraw = 0;
            }

            // if total withdraw already at limit
            if (totalWithdraw == maxWithdrawLim) {
                return null;
            }

            // check if withdraw is larger than current money
            if (withdrawAmount > oldUserInfo.getMoney()) {
                oldUserInfo.setDeposit_lim(-1); // indicates withdraw is larger than current money
                oldUserInfo.setWithdraw_lim(oldUserInfo.getMoney()); // update max withdraw limit
                return oldUserInfo;
                // if withdraw when performed, will exceed the limit
            } else if (totalWithdraw + withdrawAmount > maxWithdrawLim) {
                oldUserInfo.setWithdraw_lim(maxWithdrawLim - totalWithdraw); // update max withdraw limit
                return oldUserInfo;
            } else {
                /* Update withdraw history in database */
                PreparedStatement stCreateDeposit = conn.prepareStatement("INSERT INTO user_withdraw(user_id, money, created_at, type) VALUES(?, ?, ?, ?)");
                stCreateDeposit.setInt(1, newUserInfo.getId());
                stCreateDeposit.setInt(2, withdrawAmount);
                stCreateDeposit.setString(3, currentTime);
                stCreateDeposit.setInt(4, 0);
                stCreateDeposit.executeUpdate();

                /* Update withdraw history in database */
                PreparedStatement stUpdateMoney = conn.prepareStatement("UPDATE user_money SET total_money = ? WHERE user_id = ?");
                stUpdateMoney.setInt(1, newUserInfo.getMoney() - withdrawAmount);
                stUpdateMoney.setInt(2, newUserInfo.getId());
                stUpdateMoney.executeUpdate();
            }

        } catch (SQLException ex) {
            Logger.getLogger(Authentication.class.getName()).log(Level.SEVERE, null, ex);
            error = true; // if any errors occured
        }

        // return new user info if successful, else return old one
        if (!error) {
            newUserInfo.setMoney(newUserInfo.getMoney() - withdrawAmount); // set new user balance
            return newUserInfo;
        } else {
            return oldUserInfo;
        }
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
