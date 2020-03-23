
/**
 *
 * @author Quan Duc Loc CE140037 SE1401
 */
package rmiserver;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

/**
 * Class contains Main to run server
 * 
 */
public class RMIServer {

    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(69);
            Naming.bind("rmi://localhost:69/AuthenticationForm", new Authentication());
            System.out.println("Server Started ...");
        } catch (RemoteException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Remote Exception Occured!");
        } catch (AlreadyBoundException ex) {
            System.out.println("Already Bound Exception Occured!");
        } catch (MalformedURLException ex) {
            System.out.println("Malformed URL Exception Occured!");
        } catch (Exception ex){
            System.out.println("An unknown error occured!");
        }
    }
    
}
