package task20;

import java.nio.charset.StandardCharsets;

public class SocketListenerAdapter implements ILegacySocketListener {

    private final ISimplePacketHandler handler;

    public SocketListenerAdapter(ISimplePacketHandler handler) {
        this.handler = handler;
    }

    @Override
    public void onConnect() {
        // no-op
    }

    @Override
    public void onDisconnect() {
        // no-op
    }

    @Override
    public void onDataReceived(byte[] data) {
        String textMessage = new String(data, StandardCharsets.UTF_8);
        handler.handlePacket(textMessage);
    }

    @Override
    public void onError(int errorCode) {
        // no-op
    }

    @Override
    public void onPing() {
        // no-op
    }
}
