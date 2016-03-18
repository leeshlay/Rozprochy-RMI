package rmi.game;

import java.rmi.RemoteException;
import java.util.Random;

/**
 * Created by Asia on 2016-03-17.
 */
public class Game extends Thread {

    char[] board = {' ',' ',' ',' ',' ',' ',' ',' ',' '};

    IUser user1;
    IUser user2;
    char user1sign;
    char user2sign;
    int starting;

    public Game(IUser user1, IUser user2) {
        this.user1 = user1;
        this.user2 = user2;
        this.user1sign = 'x';
        this.user2sign = 'o';
        starting = new Random().nextInt(2);
    }

    public void run() {

        System.out.println("New game started");

        while (!check()) {
            //play

            try {
                print();
                user1.showBoard(board);
                put(user1.makeMove(),this.user1sign);
            } catch (RemoteException e) {
                e.printStackTrace();
            }

            if (check()) { break; }

            try {
                print();
                put(user2.makeMove(),this.user2sign);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public Boolean put(int n, char x) {

        if (board[n] == ' ') {
            board[n] = x;
            return true;
        }
        else {
            return false;
        }
    }

    public Boolean check()   {

        //rows horizontal
        if (board[0] == board[1] && board[1] == board[2] && board[0] != ' ') {
            return true;
        }
        if (board[3] == board[4] && board[4] == board[5] && board[3] != ' ') {
            return true;
        }
        if (board[6] == board[7] && board[7] == board[8] && board[6] != ' ') {
            return true;
        }

        //rows vertical
        if (board[0] == board[3] && board[3] == board[6] && board[0] != ' ') {
            return true;
        }
        if (board[1] == board[4] && board[4] == board[7] && board[1] != ' ') {
            return true;
        }
        if (board[2] == board[5] && board[5] == board[8] && board[2] != ' ') {
            return true;
        }

        //cross
        if (board[0] == board[4] && board[4] == board[7] && board[0] != ' ') {
            return true;
        }
        if (board[2] == board[4] && board[4] == board[6] && board[2] != ' ') {
            return true;
        }

        return false;
    }

    public void print() throws RemoteException {
        System.out.println(board[0] + " | " + board[1] + " | " + board[2]);
        System.out.println("-------------------");
        System.out.println(board[3] + " | " + board[4] + " | " + board[5]);
        System.out.println("-------------------");
        System.out.println(board[6] + " | " + board[7] + " | " + board[8]);
        System.out.println("\n\n\n");

    }
}