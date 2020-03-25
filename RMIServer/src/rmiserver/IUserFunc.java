
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

    public int createUser(String username, String password, String fullname, String phone, String email, String address, String gender) throws RemoteException;
    
    public User getUser(String phone) throws RemoteException;
    
    public User deposit(User oldInfo, int depositAmount) throws RemoteException;

    public User withdraw(User oldInfo, int withdrawAmount) throws RemoteException;

    public User transfer(User oldInfo, String recPhone, int transferAmount) throws RemoteException;

    public User changeInfo(User oldInfo, String username, String password, String fullname, String phone, String email, String address, String gender) throws RemoteException;

    public int deleteAccount() throws RemoteException;

    public int payTuition() throws RemoteException;

    public int viewTransactionHistory() throws RemoteException;
}
