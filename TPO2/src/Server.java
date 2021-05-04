import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;

public class Server {
    private static Selector selector;
    private static final SocketAddress ADDRESS = new InetSocketAddress( 3114);

    public static void main(String[] args) {
        startServer();
    }
    private static void startServer(){
        try {
            selector = Selector.open();
            ServerSocketChannel serverChannel = ServerSocketChannel.open();
            serverChannel.socket().bind(ADDRESS);
            //configure non blocking and register
            serverChannel.configureBlocking(false);
            SelectionKey serverKey= serverChannel.register(selector, SelectionKey.OP_ACCEPT);
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            System.out.println("Server started...");
            while (true) {
                //to handle incoming network traffic
                selector.select();
                Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();

                while (iterator.hasNext()) {
                    SelectionKey key = iterator.next();
                    // this is necessary to prevent the same key from coming up again the next time around.
                    iterator.remove();

                    if (key == serverKey && key.isAcceptable()) {
                        SocketChannel client = serverChannel.accept();
                        client.configureBlocking(false);
                        client.register(selector, SelectionKey.OP_READ);

                    } else if (key != serverKey && key.isReadable()) {
                        SocketChannel channel = (SocketChannel) key.channel();
                        byteBuffer.clear();
                        channel.read(byteBuffer);
                        String request = new String(byteBuffer.array(),0,byteBuffer.limit()).trim();
                        byteBuffer.clear();

                        String requestAsArray[] = request.split(" ");

                        if(requestAsArray[0].equals("add")){
                            try{
                                int a = Integer.parseInt(requestAsArray[1]);
                                int b = Integer.parseInt(requestAsArray[2]);
                                a = a + b;
                                String sum = "" + a;

                                byteBuffer.put(sum.getBytes());
                                byteBuffer.flip();
                                channel.write(byteBuffer);
                                byteBuffer.clear();
                                channel.close();

                            }catch (Exception e){
                                String error = "Wrong format, example: add 'number' 'number' ";

                                byteBuffer.put(error.getBytes());
                                byteBuffer.flip();
                                channel.write(byteBuffer);
                                byteBuffer.clear();
                                channel.close();
                            }
                        }else{
                            byteBuffer.put(request.getBytes());
                            byteBuffer.flip();
                            channel.write(byteBuffer);
                            byteBuffer.clear();
                            channel.close();
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Server not started");
        }
    }
}