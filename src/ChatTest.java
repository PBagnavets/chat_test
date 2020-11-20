public class ChatTest {

    public static final int PORT = 8080;
    public static final String MESSAGE = "hi!";

    public static void main(String[] args) {
        PairFactory factory = new PairFactory();
        factory.start();
    }
}
