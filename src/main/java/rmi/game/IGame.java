package rmi.game;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by Asia on 2016-03-17.
 */
public interface IGame extends Remote {

    public Boolean put(int n, char x) throws RemoteException;
    public Boolean check() throws RemoteException;
    public void print() throws RemoteException;
    public void playWithHuman() throws RemoteException;
    public void playWithComputer() throws RemoteException;

}
