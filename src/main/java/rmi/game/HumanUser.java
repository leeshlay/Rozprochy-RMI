package rmi.game;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.InputMismatchException;
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
    public int makeMove(char[] board) throws RemoteException {

        int move;
        try {
            do {
                System.out.println("Enter where to make move [0-8]");
                move = scan.nextInt();

                if (board[move] != ' ') {
                    System.out.println("Chosen place is not empty.");
                }
            } while (board[move] != ' ');

        } catch (IndexOutOfBoundsException e) {
            System.out.println("Only numbers [0-8] are allowed");
            move = makeMove(board);
        } /*catch (InputMismatchException e1) {
            System.out.println("Please enter a number in range [0-8]");
            move = makeMove(board);
        }*/

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
        System.out.println("\n");

    }

    @Override
    public void winning() throws RemoteException {
        System.out.println("You won!");
    }

    @Override
    public void loosing() throws RemoteException {
        System.out.println("You lost :c");
    }

    @Override
    public void trap() throws RemoteException {
        System.out.println("It's a trap...");
    }

    @Override
    public void waitForMove() throws RemoteException {
        System.out.println("Waiting for enemy's move...");
    }
}
