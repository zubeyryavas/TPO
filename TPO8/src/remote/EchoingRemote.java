package remote;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface EchoingRemote extends Remote {

    EchoResponse echo(EchoRequest request) throws RemoteException;

}