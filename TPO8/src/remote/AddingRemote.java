package remote;

import java.math.BigInteger;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface AddingRemote extends Remote {

    AddResponse add(AddRequest request) throws RemoteException;

}