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

    public Game(IUser user1, IUser user2) {
        this.user1 = user1;
        this.user2 = user2;

    }

    public void run() {

        try {
            System.out.println("New game started between " + user1.getNick() +" and " + user2.getNick());

            user1.setSign('x');
            user2.setSign('o');

            while (!check() && !isFull()) {

                user1.showBoard(board);
                put(user1.makeMove(board), user1.getSign());
                user1.showBoard(board);


                if (check()) {
                    System.out.println(user1.getNick() + " wins the game!");
                    user1.winning();
                //    user1.showBoard(board);
                    user2.loosing();
                    user2.showBoard(board);
                    break;
                }

                user1.waitForMove();

                user2.showBoard(board);
                put(user2.makeMove(board), user2.getSign());
                user2.showBoard(board);


                if (check()) {
                    System.out.println(user2.getNick() + " wins the game!");
                    user1.loosing();
                    user1.showBoard(board);
                    user2.winning();
                 //   user2.showBoard(board);
                    break;
                }

                user2.waitForMove();

            }

            if (isFull() && !check()) {
                System.out.println("No one wins");
                user1.trap();
                user1.showBoard(board);
                user2.trap();
                user2.showBoard(board);
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
        if (board[0] == board[4] && board[4] == board[8] && board[0] != ' ') {
            return true;
        }
        if (board[2] == board[4] && board[4] == board[6] && board[2] != ' ') {
            return true;
        }

        return false;
    }

    public Boolean isFull() {

        if (board[0] == ' ' || board[1] == ' ' || board[2] == ' ' || board[3] == ' ' || board[4] == ' ' ||
                board[5] == ' ' || board[6] == ' ' ||board[7] == ' ' || board[8] == ' ') {
            return false;
        }
        return true;
    }
}
