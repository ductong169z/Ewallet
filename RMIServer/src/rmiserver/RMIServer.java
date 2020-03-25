/**
 *
 * @author Wibuu Group, consists of 3 members:
 * @author Nguyen Duc Tong
 * @author Quan Duc Loc
 * @author Tran Minh Thang
 *
 */
package rmiserver;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class contains Main to run the server
 */
public class RMIServer {

    public static void main(String[] args) {
        try {
            // create 3 ports
            LocateRegistry.createRegistry(69);
            LocateRegistry.createRegistry(70);
            LocateRegistry.createRegistry(71);
            Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=Ewallet", "sa", "sa@123");
            // bind 3 classes to 3 ports with equal name
            Naming.bind("rmi://localhost:69/Authentication", new Authentication(conn)); // for authenticating login sessions
            Naming.bind("rmi://localhost:70/UserFunctions", new UserFunc(conn)); // for user functions
            Naming.bind("rmi://localhost:71/AdminFunctions", new AdminFunc(conn)); // for admin functions

            System.out.println("Server Started Successfully! ...");
        }catch (MalformedURLException | AlreadyBoundException | RemoteException | SQLException ex) {
            Logger.getLogger(RMIServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}