
/**
 *
 * @author Quan Duc Loc CE140037 SE1401
 */
package rmiserver;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Interface to provide functionalities
 * 
 */
public interface IAuthentication extends Remote{
    public User validateUser(String username, String password) throws RemoteException;
}
