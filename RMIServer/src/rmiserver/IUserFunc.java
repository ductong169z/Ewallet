
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

    public int createUser(String username, String password, String fullname, String gender, String email, String phone, String address) throws RemoteException;

    public User deposit(User oldUserInfo, int depositAmount) throws RemoteException;
<<<<<<< HEAD

    public int withdraw() throws RemoteException;

=======

    public int withdraw() throws RemoteException;

>>>>>>> parent of 6b62d43... Merge branch 'master' into Thang
    public int transfer() throws RemoteException;

    public int changeInfo() throws RemoteException;

    public int deleteAccount() throws RemoteException;

    public int viewTransactionHistory() throws RemoteException;
    
    public Map<String, String> getSchool() throws RemoteException;
    
    public String getTuition(String schoolId,String studentId) throws RemoteException;
    
    public boolean payTuition(String schoolId, String studentId) throws RemoteException;
}
