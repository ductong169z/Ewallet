
/**
 *
 * @author Quan Duc Loc CE140037 SE1401
 */
package rmiserver;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Interface to provide functionalities
 * @author Admin
 */
public interface IAuthentication extends Remote{
    public int createUser(String username, String password, String fullname, String gender, String email, String phone, String address) throws RemoteException;
    public int validateUser(String username, String password) throws RemoteException;
}
