
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
 * Class contains Main
 * @author Admin
 */
public class RMIServer {

    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(5000);
            Naming.bind("rmi://localhost:5000/AuthenticationForm", new Authentication());
            System.out.println("Server Started ...");
            
        } catch (RemoteException ex) {
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
