
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
            
            // bind 3 classes to 3 ports with equal name
            Naming.bind("rmi://localhost:69/Authentication", new Authentication()); // for authenticating login sessions
            Naming.bind("rmi://localhost:70/UserFunctions", new UserFunc()); // for user functions
            Naming.bind("rmi://localhost:71/AdminFunctions", new AdminFunc()); // for admin functions
            
            System.out.println("Server Started Successfully! ...");
        } catch (RemoteException ex) {
            Logger.getLogger(RMIServer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (AlreadyBoundException ex) {
            Logger.getLogger(RMIServer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(RMIServer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex){
            Logger.getLogger(RMIServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
