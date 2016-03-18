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

        try {
            System.out.println("New game started between " + user1.getNick() +" and " + user2.getNick());

            while (!check()) {

                user1.showBoard(board);
                put(user1.makeMove(board), this.user1sign);
                if (check()) {
                    System.out.println(user1.getNick() + " wins the game!");
                    user1.winning();
                    user1.showBoard(board);
                    user2.loosing();
                    user2.showBoard(board);
                    break;
                }


                user2.showBoard(board);
                put(user2.makeMove(board), this.user2sign);
                if (check()) {
                    System.out.println(user2.getNick() + " wins the game!");
                    user2.winning();
                    user2.showBoard(board);
                    user1.loosing();
                    user1.showBoard(board);
                    break;
                }
            }

        }  catch (RemoteException e) {
            e.printStackTrace();
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
}
