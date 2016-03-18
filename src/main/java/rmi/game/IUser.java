package rmi.game;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by Asia on 2016-03-17.
 */
public interface IUser extends Remote, Serializable {

    public int makeMove(char[] board) throws RemoteException;
    public void setNick(String nick) throws RemoteException;
    public String getNick() throws  RemoteException;
    public void showBoard(char[] board) throws RemoteException;
    public void winning() throws RemoteException;
    public void loosing() throws RemoteException;
}
