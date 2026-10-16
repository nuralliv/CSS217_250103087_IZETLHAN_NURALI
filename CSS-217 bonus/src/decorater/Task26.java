package decorater;

public class Task26 {
    interface Car { String getConfiguration(); double getPrice(); }
    static class BaseSedan implements Car {
        public String getConfiguration() { return "Standard Sedan"; }
        public double getPrice() { return 15000.0; }
    }
    static abstract class CarDecorator implements Car {
        protected final Car wrapped;
        CarDecorator(Car c) { this.wrapped = c; }
    }
    static class SunroofDecorator extends CarDecorator {
        SunroofDecorator(Car c) { super(c); }
        public String getConfiguration() { return wrapped.getConfiguration() + " + Sunroof"; }
        public double getPrice() { return wrapped.getPrice() + 1200.0; }
    }
    static class AlloyWheelsDecorator extends CarDecorator {
        AlloyWheelsDecorator(Car c) { super(c); }
        public String getConfiguration() { return wrapped.getConfiguration() + " + Alloy Wheels"; }
        public double getPrice() { return wrapped.getPrice() + 800.0; }
    }
    static class DashcamDecorator extends CarDecorator {
        DashcamDecorator(Car c) { super(c); }
        public String getConfiguration() { return wrapped.getConfiguration() + " + Dashcam"; }
        public double getPrice() { return wrapped.getPrice() + 300.0; }
    }
    public static void main(String[] args) {
        Car c = new DashcamDecorator(new AlloyWheelsDecorator(new SunroofDecorator(new BaseSedan())));
        System.out.println(c.getConfiguration() + " = " + c.getPrice());
    }
}
