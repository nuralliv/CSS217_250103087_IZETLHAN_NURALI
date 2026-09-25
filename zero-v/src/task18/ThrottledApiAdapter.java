package task18;

public class ThrottledApiAdapter implements IRateLimitedService {

    private static final long MIN_SPACING_MILLIS = 200L;

    private final ThirdPartyApiServer thirdPartyApiServer;
    private long lastInvocationTimestamp = 0L;

    public ThrottledApiAdapter(ThirdPartyApiServer thirdPartyApiServer) {
        this.thirdPartyApiServer = thirdPartyApiServer;
    }

    @Override
    public synchronized String getProtectedData() {
        long now = System.currentTimeMillis();
        long elapsed = now - lastInvocationTimestamp;

        if (lastInvocationTimestamp != 0L && elapsed < MIN_SPACING_MILLIS) {
            long remaining = MIN_SPACING_MILLIS - elapsed;
            try {
                Thread.sleep(remaining);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new IllegalStateException("Interrupted while throttling request", e);
            }
        }

        String result = thirdPartyApiServer.fetchData();
        lastInvocationTimestamp = System.currentTimeMillis();
        return result;
    }
}
