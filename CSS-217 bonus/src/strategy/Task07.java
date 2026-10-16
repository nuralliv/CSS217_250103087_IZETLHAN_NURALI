package strategy;

public class Task07 {
    interface ShippingStrategy { double calculate(double weightKg, double distanceKm); }
    static class StandardShipping implements ShippingStrategy {
        public double calculate(double w, double d) { return w * 2.0 + d * 0.5; }
    }
    static class ExpressShipping implements ShippingStrategy {
        public double calculate(double w, double d) { return w * 5.0 + d * 1.2 + 50.0; }
    }
    static class DroneShipping implements ShippingStrategy {
        public double calculate(double w, double d) { return w < 5.0 ? 100.0 : -1.0; }
    }
    public static void main(String[] args) {
        ShippingStrategy[] all = { new StandardShipping(), new ExpressShipping(), new DroneShipping() };
        for (ShippingStrategy s : all)
            System.out.println(s.getClass().getSimpleName() + ": " + s.calculate(4.0, 100.0) + " | heavy: " + s.calculate(8.0 , 100.0));
    }
}
