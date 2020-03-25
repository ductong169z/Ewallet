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
            PreparedStatement st = conn.prepareStatement("Select * from users where phone = ?");
            st.setString(1, phone);
            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                PreparedStatement getRole = conn.prepareStatement("SELECT * FROM user_role JOIN user_money ON user_role.user_id = user_money.id WHERE user_role.user_id = ? ");
                getRole.setString(1, rs.getString("id"));
                ResultSet rsRole = getRole.executeQuery();
                if (rsRole.next()) {
                    PreparedStatement getLim = conn.prepareStatement("SELECT * FROM setting");
                    ResultSet rsLim = getLim.executeQuery();

                    User user = new User(rs.getString("id"), rs.getString("username"), rs.getString("fullname"), rs.getString("phone"), rs.getString("mail"), rs.getString("address"), rs.getString("gender"), rsRole.getString("role_id"), rsRole.getString("total_money"), rsLim.getString("deposit_lim"), rsLim.getString("withdraw_lim"), rsLim.getString("trans_lim"));
                    return user;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminFunc.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
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

    /* Override methods in IAdminFunc interface */
}
