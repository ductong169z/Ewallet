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
     * @return 0 if operation successful, 1 if unsuccessful, 2 if phone number is duplicated
     * @throws RemoteException
     */
    @Override
    public int createUser(String username, String password, String fullname, String gender, String email, String phone, String address) throws RemoteException {
        boolean error = false; // check if there's any errors occured

        // add user info to database
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
    public User getUser(String phone) throws RemoteException {
        try {
            /* Get user with passed phone number */
            PreparedStatement st = conn.prepareStatement("Select * from users where phone = ?");
            st.setString(1, phone);
            ResultSet rs = st.executeQuery();

            // if such user exists
            if (rs.next()) {
                /* Get user role ID from database */
                PreparedStatement getRole = conn.prepareStatement("SELECT * FROM user_role JOIN user_money ON user_role.user_id = user_money.user_id WHERE user_role.user_id = ? ");
                getRole.setInt(1, rs.getInt("id"));
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
            Logger.getLogger(UserFunc.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("SQL ex");
            return new User(); // indicate SQL error occured
        }
        System.out.println("haha");
        return null; // user does not exist
    }

    @Override
    public User deposit(User oldInfo, int depositAmount) throws RemoteException {
        boolean error = false; // check if there's any errors occured
        User newInfo = oldInfo; // store user info after modified/updated

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

            stGetTotal.setInt(1, newInfo.getId());
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
                oldInfo.setDeposit_lim(maxDepositLim - totalDeposit); // set new deposit limit
                return oldInfo;
            } else {
                /* Update deposit history in database */
                PreparedStatement stCreateDeposit = conn.prepareStatement("INSERT INTO user_deposit(user_id, money, created_at, type) VALUES(?, ?, ?, ?)");
                stCreateDeposit.setInt(1, newInfo.getId());
                stCreateDeposit.setInt(2, depositAmount);
                stCreateDeposit.setString(3, currentTime);
                stCreateDeposit.setInt(4, 0);
                stCreateDeposit.executeUpdate();

                /* Update user money in database */
                PreparedStatement stUpdateMoney = conn.prepareStatement("UPDATE user_money SET total_money = ? WHERE user_id = ?");
                stUpdateMoney.setInt(1, depositAmount + newInfo.getMoney());
                stUpdateMoney.setInt(2, newInfo.getId());
                stUpdateMoney.executeUpdate();
            }

        } catch (SQLException ex) {
            Logger.getLogger(Authentication.class.getName()).log(Level.SEVERE, null, ex);
            error = true; // if any errors occured
        }

        // return new user info if successful, else return old one
        if (!error) {
            newInfo.setMoney(depositAmount + newInfo.getMoney()); // set new user balance
            return newInfo;
        } else {
            return oldInfo;
        }
    }

    @Override
    public User withdraw(User oldInfo, int withdrawAmount, String description) throws RemoteException {
        boolean error = false; // check if there's any errors occured
        User newInfo = oldInfo; // store user info after modified/updated

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

            stGetTotal.setInt(1, newInfo.getId());
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
            if (withdrawAmount > oldInfo.getMoney()) {
                oldInfo.setDeposit_lim(-1); // indicates withdraw is larger than current money
                oldInfo.setWithdraw_lim(oldInfo.getMoney()); // update max withdraw limit
                return oldInfo;
                // if withdraw when performed, will exceed the limit
            } else if (totalWithdraw + withdrawAmount > maxWithdrawLim) {
                oldInfo.setWithdraw_lim(maxWithdrawLim - totalWithdraw); // update max withdraw limit
                return oldInfo;
            } else {
                /* Update withdraw history in database */
                PreparedStatement stCreateWithDraw = conn.prepareStatement("INSERT INTO user_withdraw(user_id, money, created_at, type, description) VALUES(?, ?, ?, ?, ?)");
                stCreateWithDraw.setInt(1, newInfo.getId());
                stCreateWithDraw.setInt(2, withdrawAmount);
                stCreateWithDraw.setString(3, currentTime);
                stCreateWithDraw.setInt(4, 1);
                stCreateWithDraw.setString(5, description);
                stCreateWithDraw.executeUpdate();

                /* Update user money in database */
                PreparedStatement stUpdateMoney = conn.prepareStatement("UPDATE user_money SET total_money = ? WHERE user_id = ?");
                stUpdateMoney.setInt(1, newInfo.getMoney() - withdrawAmount);
                stUpdateMoney.setInt(2, newInfo.getId());
                stUpdateMoney.executeUpdate();
            }

        } catch (SQLException ex) {
            Logger.getLogger(Authentication.class.getName()).log(Level.SEVERE, null, ex);
            error = true; // if any errors occured
        }

        // return new user info if successful, else return old one
        if (!error) {
            newInfo.setMoney(newInfo.getMoney() - withdrawAmount); // set new user balance
            return newInfo;
        } else {
            return oldInfo;
        }
    }

    @Override
    public User transfer(User oldInfo, String recPhone, int transferAmount) throws RemoteException {
        boolean error = false; // check if there's any errors occured
        User newInfo = oldInfo; // store user info after modified/updated
        User recInfo = getUser(recPhone); // store recipient info

        // try perform transfer transaction
        try {
            /* Get max transfer limit in database */
            PreparedStatement stGetLim = conn.prepareStatement("SELECT * FROM setting");
            ResultSet rsGetLim = stGetLim.executeQuery();
            rsGetLim.next();

            int maxTransLim = rsGetLim.getInt("trans_lim"); // maximum transfer amount in 1 day
            int totalTrans = -1; // total transfer amount in current day
            String currentTime = java.time.LocalDate.now().toString(); // current time when user perform transfer

            /* Get the total transfer amount in current day */
            PreparedStatement stGetTotal = conn.prepareStatement("SELECT SUM(money) FROM user_transfer WHERE send_id = ? AND created_at = ?");

            stGetTotal.setInt(1, newInfo.getId());
            stGetTotal.setString(2, currentTime);

            ResultSet rsGetTotal = stGetTotal.executeQuery();

            // if there are already some transfer transactions performed earlier
            if (rsGetTotal.next()) {
                totalTrans = rsGetTotal.getInt(1);
            } else {
                totalTrans = 0;
            }

            // if total transfer already at limit
            if (totalTrans == maxTransLim) {
                return null;
            }

            // check if transfer amount is larger than current money
            if (transferAmount > oldInfo.getMoney()) {
                oldInfo.setDeposit_lim(-1); // indicates transfer amount is larger than current money
                oldInfo.setTrans_lim(oldInfo.getMoney()); // update max transfer limit
                return oldInfo;
                // if transfer when performed, will exceed the limit
            } else if (totalTrans + transferAmount > maxTransLim) {
                oldInfo.setTrans_lim(maxTransLim - totalTrans); // update max transfer limit
                return oldInfo;
            } else {
                /* Update transfer history in database */
                PreparedStatement stCreateTransfer = conn.prepareStatement("INSERT INTO user_transfer(send_id, receive_id, money, created_at, type) VALUES(?, ?, ?, ?, ?)");
                stCreateTransfer.setInt(1, newInfo.getId());
                stCreateTransfer.setInt(2, recInfo.getId());
                stCreateTransfer.setInt(3, transferAmount);
                stCreateTransfer.setString(4, currentTime);
                stCreateTransfer.setInt(5, 2);
                stCreateTransfer.executeUpdate();

                /* Update sender money in database */
                PreparedStatement stSenderUpdate = conn.prepareStatement("UPDATE user_money SET total_money = ? WHERE user_id = ?");
                stSenderUpdate.setInt(1, newInfo.getMoney() - transferAmount);
                stSenderUpdate.setInt(2, newInfo.getId());
                stSenderUpdate.executeUpdate();

                /* Update recipient money in database */
                PreparedStatement stRecUpdate = conn.prepareStatement("UPDATE user_money SET total_money = ? WHERE user_id = ?");
                stRecUpdate.setInt(1, recInfo.getMoney() + transferAmount);
                stRecUpdate.setInt(2, recInfo.getId());
                stRecUpdate.executeUpdate();
            }

        } catch (SQLException ex) {
            Logger.getLogger(Authentication.class.getName()).log(Level.SEVERE, null, ex);
            error = true; // if any errors occured
        }

        // return new user info if successful, else return old one
        if (!error) {
            newInfo.setMoney(newInfo.getMoney() - transferAmount); // set new user balance
            return newInfo;
        } else {
            return oldInfo;
        }
    }

     @Override
    public User changeInfo(User oldInfo, String username, String password, String fullname, String phone, String mail, String address, String gender) throws RemoteException {
        String hashPassword = ""; // store MD5 hashed version of password

        try {
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
                Logger.getLogger(UserFunc.class.getName()).log(Level.SEVERE, null, ex);
                oldInfo.setUsername("Error");
                return oldInfo;
            }

            /* Check if password is correct */
            PreparedStatement stCheckPass = conn.prepareStatement("SELECT * FROM users WHERE id = ? AND password = ?");
            stCheckPass.setInt(1, oldInfo.getId());
            stCheckPass.setString(2, hashPassword);
            ResultSet rsCheckPass = stCheckPass.executeQuery();

            /* Check if phone exists in database (on another account) */
            PreparedStatement stCheckPhone = conn.prepareStatement("SELECT * FROM users WHERE phone = ? AND id != ?");
            stCheckPhone.setString(1, phone);
            stCheckPhone.setInt(2, oldInfo.getId());
            ResultSet rsCheckPhone = stCheckPhone.executeQuery();

            /* Check if username already exists in database */
            PreparedStatement stCheckUsername = conn.prepareStatement("SELECT * FROM users WHERE username = ? AND id != ?");
            stCheckUsername.setString(1, username);
            stCheckUsername.setInt(2, oldInfo.getId());
            ResultSet rsCheckUsername = stCheckUsername.executeQuery();

            if (rsCheckPhone.next()) {
                oldInfo.setPhone("-1");
                return oldInfo;
            } else if (rsCheckUsername.next()) {
                oldInfo.setUsername("-1");
                return oldInfo;
            } else if (rsCheckPass.next()) {
                PreparedStatement stUpdateInfo = conn.prepareStatement("UPDATE users SET username = ?, fullname = ?, phone = ?, mail = ?, address = ?, gender = ? WHERE id = ?");
                stUpdateInfo.setString(1, username);
                stUpdateInfo.setString(2, fullname);
                stUpdateInfo.setString(3, phone);
                stUpdateInfo.setString(4, mail);
                stUpdateInfo.setString(5, address);
                stUpdateInfo.setString(6, gender);
                stUpdateInfo.setInt(7, oldInfo.getId());
                stUpdateInfo.executeUpdate();

                return new User(String.valueOf(oldInfo.getId()), username, fullname, phone, mail, address, gender, String.valueOf(oldInfo.getRole_id()), String.valueOf(oldInfo.getMoney()), String.valueOf(oldInfo.getDeposit_lim()), String.valueOf(oldInfo.getWithdraw_lim()), String.valueOf(oldInfo.getTrans_lim()));
            } else {
                return null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserFunc.class.getName()).log(Level.SEVERE, null, ex);
            return new User(); // indicate SQL error occured
        }

    }

    @Override
    public int changePassword(User userInfo, String oldPassword, String newPassword) throws RemoteException {

        try {
            String hashOldPassword = ""; // store MD5 hashed version of password

            /* code to hash old password using MD5 algorithm */
            try {
                MessageDigest md = MessageDigest.getInstance("MD5");

                byte[] messageDigest = md.digest(oldPassword.getBytes());

                BigInteger no = new BigInteger(1, messageDigest);

                // Convert message digest into hex value
                hashOldPassword = no.toString(16);
                while (hashOldPassword.length() < 32) {
                    hashOldPassword = "0" + hashOldPassword;
                }
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(UserFunc.class.getName()).log(Level.SEVERE, null, ex);
                return 2; // encrypt error
            }

            /* Check if password is correct */
            PreparedStatement stCheckPass = conn.prepareStatement("SELECT * FROM users WHERE id = ? AND password = ?");
            stCheckPass.setInt(1, userInfo.getId());
            stCheckPass.setString(2, hashOldPassword);
            ResultSet rsCheckPass = stCheckPass.executeQuery();

            String hashNewPassword = ""; // re-initialize hashOldPassword to store MD5 hashed new password

            /* code to hash new password using MD5 algorithm */
            try {
                MessageDigest md = MessageDigest.getInstance("MD5");

                byte[] messageDigest = md.digest(newPassword.getBytes());

                BigInteger no = new BigInteger(1, messageDigest);

                // Convert message digest into hex value
                hashNewPassword = no.toString(16);
                while (hashNewPassword.length() < 32) {
                    hashNewPassword = "0" + hashNewPassword;
                }
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(UserFunc.class.getName()).log(Level.SEVERE, null, ex);
                return 2; // encrypt error
            }

            // if password is correct
            if (rsCheckPass.next()) {
                /* Update new password in database */
                PreparedStatement stUpdatePass = conn.prepareStatement("UPDATE users SET password = ? WHERE id = ? AND password = ?");
                stUpdatePass.setString(1, hashNewPassword);
                stUpdatePass.setInt(2, userInfo.getId());
                stUpdatePass.setString(3, hashOldPassword);
                stUpdatePass.executeUpdate();

                return 0; // successful
            } else {
                return 3; // password is incorrect
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserFunc.class.getName()).log(Level.SEVERE, null, ex);
            return 1;
        }
    }

    @Override
    public int deleteAccount(User userInfo, String password) throws RemoteException {
        String hashPassword = ""; // store MD5 hashed version of password

        try {
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
                Logger.getLogger(UserFunc.class.getName()).log(Level.SEVERE, null, ex);
                return 2;
            }

            /* Check if password is correct */
            PreparedStatement stCheckPass = conn.prepareStatement("SELECT * FROM users WHERE id = ? AND password = ?");
            stCheckPass.setInt(1, userInfo.getId());
            stCheckPass.setString(2, hashPassword);
            ResultSet rsCheckPass = stCheckPass.executeQuery();

            // if password is correct
            if (rsCheckPass.next()) {
                /* SQL Statements to delete user from 3 tables in database */
                PreparedStatement stDeleteUser = conn.prepareStatement("DELETE FROM users WHERE id = ?");
                stDeleteUser.setInt(1, userInfo.getId());
                
                PreparedStatement stDeleteUserRole = conn.prepareStatement("DELETE FROM user_role WHERE user_id = ?");
                stDeleteUserRole.setInt(1, userInfo.getId());
                
                PreparedStatement stDeleteUserMoney = conn.prepareStatement("DELETE FROM user_money WHERE user_id = ?");
                stDeleteUserMoney.setInt(1, userInfo.getId());

                /* Execute 3 statements at once */
                stDeleteUser.executeUpdate();
                stDeleteUserRole.executeUpdate();
                stDeleteUserMoney.executeUpdate();
            } else {
                return 3;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserFunc.class.getName()).log(Level.SEVERE, null, ex);
            return 1;
        }

        return 0;
    }

    @Override
    public int viewTransactionHistory() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public Map<String, String> getSchool() throws RemoteException {
        Map<String, String> schoolname = new HashMap<>();
        try {
            PreparedStatement st = conn.prepareStatement("select id, name from universities");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
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
            PreparedStatement st = conn.prepareStatement("select tuition.name, tuition.tuition from dbo.tuition where tuition.id_student like ? and tuition.id_uni = ? ");
            st.setString(1, studentId);
            st.setString(2, schoolId);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
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
            PreparedStatement st = conn.prepareStatement("update dbo.tuition set tuition.tuition = 0 where tuition.id_student like ? and tuition.id_uni = ? ");
            st.setString(1, studentId);
            st.setString(2, schoolId);
            int count = st.executeUpdate();
            if (count > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserFunc.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
