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
import java.util.ArrayList;

public interface IAdminFunc extends Remote {

    public int createUser(String username, String password, String fullname, String gender, String email, String phone, String address, int role) throws RemoteException;

    public User getUser(String phone) throws RemoteException;

    public boolean changePassword(String id, String password) throws RemoteException;

    public boolean suspendUser(int id) throws RemoteException;

    public ArrayList<ReportList> getReportAll(String method) throws RemoteException;

}
