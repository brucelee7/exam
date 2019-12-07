package controller;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIServer {
    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(7799);
            Registry registry = LocateRegistry.getRegistry("localhost", 7799);
            registry.rebind("data", new ApiImpl());
            System.out.println("Server is listening port 7799 ..");
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
