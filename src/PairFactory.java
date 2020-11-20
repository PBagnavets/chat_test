import java.io.*;
import java.net.ConnectException;
import java.net.Socket;

public class PairFactory extends Thread {

    private static int userNumber = 0;

    @Override
    public void run() {
        try {
            while (true) {
                Socket socket1 = new Socket("localhost", ChatTest.PORT);

                PrintWriter writer1 = new PrintWriter(socket1.getOutputStream(), true);

                writer1.println("user" + userNumber++);

                Socket socket2 = new Socket("localhost", ChatTest.PORT);

                PrintWriter writer2 = new PrintWriter(socket2.getOutputStream(), true);

                sleep(100);
                writer2.println("user" + userNumber++);
                sleep(100);
                writer2.println("user" + (userNumber - 2));

                PairChat pairChat = new PairChat(writer1, writer2);
                pairChat.start();
                System.out.print("Users created: " + userNumber + "  ...  ");
                System.out.println("Message sent: " + PairChat.messageSent);
                sleep(50);
            }
        } catch (ConnectException e) {
            System.out.println("Server down");
            System.exit(0);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
