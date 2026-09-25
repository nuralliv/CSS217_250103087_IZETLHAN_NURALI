package task09;

public class Main {
    public static void main(String[] args) {
        TwoWaySpeedAdapter speed = new TwoWaySpeedAdapter();

        speed.setSpeedMph(60);
        System.out.println("60 mph -> " + speed.getSpeedKmh() + " km/h");

        speed.setSpeedKmh(100);
        System.out.println("100 km/h -> " + speed.getSpeedMph() + " mph");
    }
}
