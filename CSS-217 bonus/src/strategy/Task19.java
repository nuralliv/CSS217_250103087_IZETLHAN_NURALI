package strategy;

public class Task19 {
    interface  TaxStrategy {
        double calculateTax(double income) ;
    }
    static class ZeroTax implements TaxStrategy {
        public double calculateTax(double income) { return 0.0; }
    }
    static class FlatTax implements TaxStrategy {
        public double calculateTax(double income) { return income * 0.10; }
    }
    static class ProgressiveTax implements TaxStrategy {
        public double calculateTax(double income) {
            if (income <= 100000.0) return income * 0.05;
            return 100000.0 * 0.05 + (income - 100000.0) * 0.20;
        }
    }
    public static void main(String[] args) {
        TaxStrategy[] all = { new ZeroTax(), new FlatTax(), new ProgressiveTax() };
        for (TaxStrategy t : all)
            System.out.println(t.getClass().getSimpleName() + ": " + t.calculateTax(50000.0) + " / " + t.calculateTax(150000.0));
    }
}
