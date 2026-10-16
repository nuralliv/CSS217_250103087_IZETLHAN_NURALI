package decorater;

public class Task02 {
    interface Beverage { String getDescription(); double getCost(); }
    static class Espresso implements Beverage {
        public String getDescription() { return "Espresso"; }
        public double getCost() { return 100.0; }
    }

    static abstract class BeverageDecorator implements Beverage {
        protected final Beverage wrapped;
        BeverageDecorator(Beverage b) { this.wrapped = b; }
    }
    static class MilkDecorator extends BeverageDecorator {
        MilkDecorator(Beverage b) { super(b); }
        public String getDescription() { return wrapped.getDescription() + ", Milk"; }
        public double getCost() { return wrapped.getCost() + 20.0; }
    }static class CaramelDecorator extends BeverageDecorator {
        CaramelDecorator(Beverage b) { super(b); }
        public String getDescription() { return wrapped.getDescription() + ", Caramel"; }
        public double getCost() { return wrapped.getCost() + 35.0; }
    }
    static class WhippedCreamDecorator extends BeverageDecorator {
        WhippedCreamDecorator(Beverage b) { super(b); }
        public String getDescription() { return wrapped.getDescription() + ", Whipped Cream"; }
        public double getCost() { return wrapped.getCost() + 25.0; }
    }
    public static void main(String[] args) {
        Beverage b = new WhippedCreamDecorator(new CaramelDecorator(new MilkDecorator(new Espresso())));
        System.out.println(b.getDescription() + " = " + b.getCost());
    }
}
