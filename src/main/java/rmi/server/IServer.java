package rmi.server;

import rmi.game.IUser;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by Asia on 2016-03-17.
 */
public interface IServer extends Remote {

    public void register(IUser user, int rival) throws RemoteException, InterruptedException;
    public Boolean checkNick(IUser user) throws RemoteException;
    }
