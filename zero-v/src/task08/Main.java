package task08;

public class Main {
    public static void main(String[] args) {
        TelemetryLoggerAdapter logger = new TelemetryLoggerAdapter(new EnterpriseTelemetryLogger(), "DemoApp");
        logger.info("System started");
        logger.warn("Disk usage high");
        logger.error("Connection lost");
    }
}
