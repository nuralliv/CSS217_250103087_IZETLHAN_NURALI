package strategy;

public class Task22 {
    interface RouteStrategy { int estimateMinutes(int distanceKm); }
    static class WalkingStrategy implements RouteStrategy {
        public int estimateMinutes(int d) { return d * 12; }
    }
    static class CyclingStrategy implements RouteStrategy {
        public int estimateMinutes(int d) { return d * 4; }
    }
    static class DrivingStrategy implements RouteStrategy {
        public int estimateMinutes(int d) { return d * 1 + 10; }
    }
    public static void main(String[] args) {
        RouteStrategy[] all = { new WalkingStrategy(), new CyclingStrategy(), new DrivingStrategy() };
        for (RouteStrategy r : all)
            System.out.println(r.getClass().getSimpleName() + ": " + r.estimateMinutes(10) + " min");
    }
}
