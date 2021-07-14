import remote.RemoteObject;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public final class Server {

    public static void main(String[] args) throws Exception {

        // rmi.Naming uses rmi.registry.Registry internally so i decided to use in this way.
        Registry registry = LocateRegistry.createRegistry(Configuration.PORT);
        RemoteObject remote = new RemoteObject();
        registry.bind(Configuration.ADDING_REMOTE_URI, remote);
        registry.bind(Configuration.ECHOING_REMOTE_URI, remote);
        System.out.printf("RMI Server started at port %d.", Configuration.PORT);
    }
}