package rmi.game;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

/**
 * Created by Asia on 2016-03-17.
 */
public class HumanUser extends UnicastRemoteObject implements IUser {

    String nick;
    static Scanner scan = new Scanner(System.in);

    public HumanUser() throws RemoteException {
    }


    @Override
    public Boolean put(int n, char x) throws RemoteException {
        return null;
    }

    @Override
    public int makeMove() throws RemoteException {

        System.out.println("Enter where to make move [0-8]");
        int move = scan.nextInt();
        return move;
    }

    @Override
    public void setNick(String nick) throws RemoteException {
        this.nick = nick;
    }

    @Override
    public String getNick() throws RemoteException {
        return nick;
    }

    @Override
    public void showBoard(char[] board) throws RemoteException {

        System.out.println(board[0] + " | " + board[1] + " | " + board[2]);
        System.out.println("-------------------");
        System.out.println(board[3] + " | " + board[4] + " | " + board[5]);
        System.out.println("-------------------");
        System.out.println(board[6] + " | " + board[7] + " | " + board[8]);
        System.out.println("\n\n\n");

    }
}