package decorater;

public class Task08 {
    interface Pizza { String getDetails(); int getPrice(); }
    static class Margherita implements Pizza {
        public String getDetails() { return "Margherita"; }
        public int getPrice() { return 200; }
    }static abstract class PizzaDecorator implements Pizza {
        protected final Pizza wrapped;
        PizzaDecorator(Pizza p) { this.wrapped = p; }
    }
    static class ExtraCheese extends PizzaDecorator {
        ExtraCheese(Pizza p) { super(p); }
        public String getDetails() { return wrapped.getDetails() + " + Extra Cheese"; }
        public int getPrice() { return wrapped.getPrice() + 40; }
    }
    static class Olives extends PizzaDecorator {
        Olives(Pizza p) { super(p); }
        public String getDetails() { return wrapped.getDetails() + " + Olives"; }
        public int getPrice() { return wrapped.getPrice() + 30; }
    }
    static class Jalapenos extends PizzaDecorator {
        Jalapenos(Pizza p) { super(p); }
        public String getDetails() { return wrapped.getDetails() + " + Jalapenos"; }
        public int getPrice() { return wrapped.getPrice() + 25; }
    }
    public static void main(String[] args) {
        Pizza p = new Jalapenos(new Olives(new ExtraCheese(new Margherita())));
        System.out.println(p.getDetails() + " = " + p.getPrice());
    }
}
