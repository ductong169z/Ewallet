/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmiserver;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Quan Duc Loc CE140037 (SE1401)
 */
public interface IUserFunc extends Remote {

    public int createUser(String username, String password, String fullname, String gender, String email, String phone, String address) throws RemoteException;

    public int deposit() throws RemoteException;

    public int withdraw() throws RemoteException;

    public int transfer() throws RemoteException;

    public int changeInfo() throws RemoteException;

    public int deleteAccount() throws RemoteException;

    public int payTuition() throws RemoteException;

    public int viewTransactionHistory() throws RemoteException;
}
