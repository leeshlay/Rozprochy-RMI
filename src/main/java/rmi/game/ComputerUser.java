package rmi.game;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Random;

/**
 * Created by Asia on 2016-03-17.
 */
public class ComputerUser extends UnicastRemoteObject implements IUser {
    public ComputerUser() throws RemoteException {
    }

    @Override
    public Boolean put(int n, char x) throws RemoteException {



        return null;
    }

    @Override
    public int makeMove() throws RemoteException {
        return new Random().nextInt(9);
    }

    @Override
    public void setNick(String nick) throws RemoteException {

    }

    @Override
    public String getNick() throws RemoteException {
        return null;
    }

    @Override
    public void showBoard(char[] board) throws RemoteException {

    }
}
