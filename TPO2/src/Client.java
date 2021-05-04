import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {
        clientStart();
    }

    public static void clientStart(){

        try{
            SocketAddress hostAddress = new InetSocketAddress( 3114);
            SocketChannel client = SocketChannel.open();
            client.connect(hostAddress);
            client.configureBlocking(false);
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            System.out.println("Client... started");

            while (true){
                System.out.println("Please enter a message to be echoed or a command and 2 integers ");
                Scanner sc = new Scanner(System.in);
                String request = sc.nextLine();
                byteBuffer.clear();
                byteBuffer.put(request.getBytes());
                byteBuffer.flip();
                client.write(byteBuffer);
                byteBuffer.clear();

                String requestAsArray[] = request.split(" ");
                if(requestAsArray[0].equals("add")){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    client.read(byteBuffer);
                    byteBuffer.flip();
                    String answer = new String(byteBuffer.array(),0,byteBuffer.limit());
                    System.out.println("Answer is " + answer);
                }else{
                    try {
                        Thread.sleep(1000);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    client.read(byteBuffer);
                    byteBuffer.flip();
                    String echo = new String(byteBuffer.array(),0,byteBuffer.limit());
                    System.out.println(echo);
                }
                client.close();
                return;
            }
        }
        catch (IOException exc){
            System.out.println("There is no server on port 3114");
        }
    }
}