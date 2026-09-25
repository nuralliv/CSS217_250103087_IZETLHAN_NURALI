package task14;

public class Main {
    public static void main(String[] args) {
        TelemetryFeedAdapter feed = new TelemetryFeedAdapter(new LegacySensorFeed());
        System.out.println("Telemetry: " + feed.getCleanTelemetry());
    }
}
