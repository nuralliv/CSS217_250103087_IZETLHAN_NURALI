package task20;

public class Main {
    public static void main(String[] args) {
        SocketListenerAdapter listener = new SocketListenerAdapter(
                message -> System.out.println("Received packet: " + message)
        );
        new LegacySocket().registerListener(listener);
    }
}
