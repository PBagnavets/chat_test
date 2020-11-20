import java.io.BufferedReader;
import java.io.PrintWriter;

public class PairChat extends Thread {

    private final PrintWriter writer1;
    private final PrintWriter writer2;
    public static int messageSent = 0;


    public PairChat(PrintWriter w1, PrintWriter w2) {
        this.writer1 = w1;
        this.writer2 = w2;
    }

    @Override
    public void run() {
        while (true) {
            try {
                String input = null;
                writer1.println(ChatTest.MESSAGE);
                messageSent++;
                sleep(2500);

                writer2.println(ChatTest.MESSAGE);
                messageSent++;
                sleep(2500);


            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
