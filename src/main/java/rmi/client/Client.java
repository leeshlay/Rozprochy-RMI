package rmi.client;

import com.sun.org.apache.bcel.internal.generic.IUSHR;
import com.sun.org.apache.xerces.internal.parsers.CachingParserPool;
import com.sun.org.apache.xpath.internal.SourceTree;
import rmi.game.HumanUser;
import rmi.game.IGame;
import rmi.game.IUser;
import rmi.server.IServer;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

/**
 * Created by Asia on 2016-03-17.
 */
public class Client {

    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        try {

            Object o = Naming.lookup("rmi://localhost:1099/server");
            IServer server = (IServer) o;

            HumanUser user = new HumanUser();

            System.out.println("Enter your nickname");
            String nick = scan.nextLine();

            user.setNick(nick);

            //z kim grac? 0 czy 1

            server.register(user, 0);



        } catch (NotBoundException | MalformedURLException | RemoteException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
