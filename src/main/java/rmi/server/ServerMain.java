package rmi.server;

import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import rmi.game.*;

/**
 * Created by Asia on 2016-03-17.
 */
public class ServerMain {

    static  IServer serverImpl;


    public static void main(String[] args) {

        if (args.length != 2) {
            System.out.println("Usage: java Server <HOST> <PORT>");
            System.exit(-1);
        }

        String host = args[0];
        String port = args[1];

        try {
            String hostname = InetAddress.getLocalHost().getHostAddress();
            System.out.println("This host IP is " + hostname);
            System.setProperty("java.rmi.server.hostname", hostname);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }



        try {
            serverImpl = new ServerImpl();
            IServer server = (IServer) UnicastRemoteObject.exportObject(serverImpl,0);
            Naming.rebind("rmi://"+ host +":"+ port + "/server",server);

        } catch (RemoteException | MalformedURLException e) {
            e.printStackTrace();
        }


    }
}
