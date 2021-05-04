import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import static java.lang.Thread.*;

public class Write {

    public static void main(String[] args) {
        Write writer = new Write();
        writer.writing_mode();
    }

    private FileChannel channel;
    private MappedByteBuffer mappedByteBuffer;
    private final int STOP = 0;
    private final int CONTINUE = 1;
    private final int BUFFER_SIZE = 50;
    private final String[] Student_numbers = {"s20697","s00000","s11111","s22222","s33333"
                                             ,"s44444","s55555","s66666","s77777","s88888"};

    Write() {
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

    public void writing_mode() {
        mappedByteBuffer.putInt(1);
        int lines = 0;
        while (true) {

            if (mappedByteBuffer.position(0).getInt() == CONTINUE) {

                mappedByteBuffer.rewind();
                mappedByteBuffer
                        .putInt(STOP)
                        .put(Student_numbers[lines].getBytes());

                System.out.println(Student_numbers[lines]);

                lines++;
                if (lines >= Student_numbers.length)
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