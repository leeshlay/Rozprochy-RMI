package rmi.game;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Random;

/**
 * Created by Asia on 2016-03-17.
 */
public class ComputerUser extends UnicastRemoteObject implements IUser {

    char sign;

    public ComputerUser() throws RemoteException {
    }



    @Override
    public int makeMove(char[] board) throws RemoteException {

        int rand = new Random().nextInt(9);
        while (board[rand] != ' ') {
            rand = new Random().nextInt(9);
        }

        return rand;
    }

    @Override
    public void setNick(String nick) throws RemoteException {

    }

    @Override
    public String getNick() throws RemoteException {
        return "Computer";
    }

    @Override
    public void showBoard(char[] board) throws RemoteException {

    }

    @Override
    public void winning() throws RemoteException {

    }

    @Override
    public void loosing() throws RemoteException {

    }

    @Override
    public void trap() throws RemoteException {

    }

    @Override
    public void waitForMove() throws RemoteException {

    }

    @Override
    public void setSign(char x) throws RemoteException {
        this.sign = x;
    }

    @Override
    public char getSign() throws RemoteException {
        return this.sign;
    }
}
