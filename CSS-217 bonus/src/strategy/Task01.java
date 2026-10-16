package strategy;

public class Task01 {
    interface DiscountStrategy { double applyDiscount(double price); }
    static class FlatDiscount implements DiscountStrategy {
        public double applyDiscount(double price) { return Math.max(0.0, price - 50.0); }
    }
    static class PercentageDiscount implements DiscountStrategy {
        public double applyDiscount(double price) { return price * 0.85; }
    }
    static class SeasonalDiscount implements DiscountStrategy {
        public double applyDiscount(double price) { return price > 500.0 ? price * 0.75 : price * 0.95; }
    }
    static class ShoppingCart {
        private DiscountStrategy strategy;
        ShoppingCart(DiscountStrategy strategy) { this.strategy = strategy; }
        void setStrategy(DiscountStrategy s) { this.strategy = s; }
        double checkout(double total) {
            double result = strategy.applyDiscount(total);
            System.out.println("Total: " + total + " -> Final: " + result);
            return result;
        }
    }
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart(new FlatDiscount());
        cart.checkout(30.0);
        cart.checkout(200.0);
        cart.setStrategy(new PercentageDiscount());
        cart.checkout(200.0);
        cart.setStrategy(new SeasonalDiscount());
        cart.checkout(600.0);
        cart.checkout(400.0);
    }
}
