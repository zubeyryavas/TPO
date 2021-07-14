import remote.*;

import java.math.BigInteger;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public final class Client {

    public static void main(String[] args) throws Exception {

        // rmi.Naming uses rmi.registry.Registry internally so i decided to use in this way.
        Registry registry = LocateRegistry.getRegistry(Configuration.PORT);
        System.out.printf("RMI Client started at port %d.%n", Configuration.PORT);

        AddingRemote addingRemote = (AddingRemote)registry.lookup(Configuration.ADDING_REMOTE_URI);
        BigInteger value1 = new BigInteger("123345636457453");
        BigInteger value2 = new BigInteger("989755241313435");
        AddRequest addRequest = new AddRequest(value1,value2);
        AddResponse addResponse = addingRemote.add(addRequest);
        System.out.printf("value 1: %d and value 2: %d\n",value1, value2);
        System.out.printf("Sum: %d\n", addResponse.getSum());

        EchoingRemote echoingRemote = (EchoingRemote)registry.lookup(Configuration.ECHOING_REMOTE_URI);
        EchoRequest echoRequest = new EchoRequest("The message which will be echoed.");
        EchoResponse echoResponse = echoingRemote.echo(echoRequest);
        System.out.printf("Request : %s\n", echoRequest.getMessage());
        System.out.printf("Response: %s", echoResponse.getEchoMessage());

    }

}