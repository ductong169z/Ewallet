
/**
 * 
 * @author Wibuu Group, consists of 3 members:
 * @author Nguyen Duc Tong
 * @author Quan Duc Loc
 * @author Tran Minh Thang
 * 
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
