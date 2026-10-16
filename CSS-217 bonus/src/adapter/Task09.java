package adapter;

public class Task09 {
    interface MetricSpeedometer { double getSpeedKmh(); }
    static class ImperialSpeedometer { double getSpeedMph() { return 60.0; } }
    static class SpeedAdapter implements MetricSpeedometer {
        private final ImperialSpeedometer legacy;
        SpeedAdapter(ImperialSpeedometer l) { this.legacy = l; }
        public double getSpeedKmh() { return legacy.getSpeedMph() * 1.60934; }
    }
    public static void main(String[] args) {
        MetricSpeedometer s = new SpeedAdapter(new ImperialSpeedometer());
        System.out.printf("%.3f km/h%n", s.getSpeedKmh());
    }
}
