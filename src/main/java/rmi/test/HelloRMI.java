package rmi.test;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface HelloRMI extends Remote {
    String sayHello() throws RemoteException;
}
