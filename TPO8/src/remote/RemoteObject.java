package remote;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RemoteObject extends UnicastRemoteObject implements AddingRemote, EchoingRemote {
    public RemoteObject() throws RemoteException {
    }

    @Override
    public AddResponse add(AddRequest request) throws RemoteException {
        return new AddResponse(request);
    }

    @Override
    public EchoResponse echo(EchoRequest request) throws RemoteException {
        return new EchoResponse(request);
    }
}
