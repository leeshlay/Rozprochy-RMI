package rmi.server;

import java.net.MalformedURLException;
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

        serverImpl = new ServerImpl();

        try {

            IServer server = (IServer) UnicastRemoteObject.exportObject(serverImpl,0);
            Naming.rebind("rmi://localhost:1099/server",server);



        } catch (RemoteException | MalformedURLException e) {
            e.printStackTrace();
        }


    }
}
