package rmi.client;

import rmi.game.HumanUser;
import rmi.server.IServer;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

/**
 * Created by Asia on 2016-03-17.
 */
public class Client {

    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        if (args.length != 3) {
            System.out.println("Usage: <HOST> <PORT> <NICK>");
        }

        String host = args[0];
        String port = args[1];
        String nick = args[2];

        try {

            Registry registry = LocateRegistry.getRegistry(host, Integer.parseInt(port));
            IServer server = (IServer) registry.lookup("server");

        //    Object o = Naming.lookup("rmi://localhost:1099/server");
        //    IServer server = (IServer) o;

            HumanUser user = new HumanUser();

            user.setNick(nick);

            if (!server.checkNick(user)) {
                System.out.println("This nick is taken. Try another one");
                System.exit(-1);
            }


            System.out.println("Who do you want to play with? 0 - computer, 1 - human");

            int withWho = scan.nextInt();

            server.register(user, withWho);



        } catch (NotBoundException | RemoteException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
