package task20;

public class LegacySocket {
    public void registerListener(ILegacySocketListener listener) {
        listener.onDataReceived("HELLO_WORLD".getBytes());
    }
}
