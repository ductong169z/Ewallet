
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

public interface IUserFunc extends Remote {

    public int createUser(String username, String password, String fullname, String gender, String email, String phone, String address) throws RemoteException;
    
    public User deposit(User oldUserInfo, int depositAmount) throws RemoteException;

    public User withdraw(User oldUserInfo, int withdrawAmount) throws RemoteException;

    public int transfer() throws RemoteException;

    public int changeInfo() throws RemoteException;

    public int deleteAccount() throws RemoteException;

    public int payTuition() throws RemoteException;

    public int viewTransactionHistory() throws RemoteException;
}
