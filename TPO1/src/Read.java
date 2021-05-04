import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import static java.lang.Thread.*;

public class Read {

    public static void main(String[] args){
        Read reader = new Read();
        reader.reading_mode();
    }

    private final int STOP = 1;
    private final int CONTINUE = 0;
    private final int BUFFER_SIZE=50;
    private FileChannel channel;
    private MappedByteBuffer mappedByteBuffer;


    Read() {
        try {
            channel = new RandomAccessFile(new File("file.txt"), "rw").getChannel();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            mappedByteBuffer = channel.map(FileChannel.MapMode.READ_WRITE, 0, BUFFER_SIZE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void reading_mode() {
        int lines = 0;
        StringBuilder output;
        String read= " READ";
        while(true){

            if (mappedByteBuffer.position(0).getInt() == CONTINUE){

                byte[] text = new byte[6];

                mappedByteBuffer.position(4);
                mappedByteBuffer.get(text);

                String readLine = new String(text);
                output = new StringBuilder();
                output.append(readLine).insert(6,read);
                System.out.println(output);

                mappedByteBuffer.rewind();
                mappedByteBuffer.putInt(STOP);

                lines++;
                if(lines >= 10)
                    break;
            }
            try {
                sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}