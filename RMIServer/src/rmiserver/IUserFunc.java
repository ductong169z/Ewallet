
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
import java.util.Map;

public interface IUserFunc extends Remote {

    public int createUser(String username, String password, String fullname, String phone, String email, String address, String gender) throws RemoteException;
    
    public User getUser(String phone) throws RemoteException;
    
    public User deposit(User oldInfo, int depositAmount) throws RemoteException;

    public User withdraw(User oldInfo, int withdrawAmount, String description) throws RemoteException;

    public User transfer(User oldInfo, String recPhone, int transferAmount) throws RemoteException;

    public User changeInfo(User oldInfo, String username, String password, String fullname, String phone, String email, String address, String gender) throws RemoteException;

    public int deleteAccount(User userInfo, String password) throws RemoteException;

    public Map<String, String> getSchool() throws RemoteException;

    public String getTuition(String schoolId, String studentId) throws RemoteException;

    public boolean payTuition(String schoolId, String studentId) throws RemoteException;

    public int viewTransactionHistory() throws RemoteException;
}
