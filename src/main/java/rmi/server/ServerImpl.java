package rmi.server;

import rmi.game.ComputerUser;
import rmi.game.Game;
import rmi.game.IUser;

import java.rmi.RemoteException;
import java.util.LinkedList;

/**
 * Created by Asia on 2016-03-17.
 */
public class ServerImpl implements IServer {

    LinkedList<IUser> waitingUsers = new LinkedList<>();

    public void register(IUser user, int rival) throws RemoteException, InterruptedException {
        //user registeres
        System.out.println("Hello in registering");

        Game game = null;

        if (rival == 0) {
            //start game with computer
            game = new Game(user, new ComputerUser());
        }
        else {
            if (waitingUsers.isEmpty()) {
                waitingUsers.add(user);
            }
            else {
                //start game with user

                game = new Game(user, waitingUsers.getFirst());
                waitingUsers.remove(waitingUsers.getFirst());
            }
        }

        if (game != null) {
            game.start();
            game.join();
        }
    }

}
