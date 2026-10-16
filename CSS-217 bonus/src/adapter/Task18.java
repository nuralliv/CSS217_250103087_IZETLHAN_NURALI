package adapter;

public class Task18 {
       interface UsdPaymentProcessor { void payInUsd(double dollars); }
    static class InrBankGateway {
        void processRupees(double rupees) { System.out.println("Processed INR " + rupees); }
    }
    static class CurrencyAdapter implements UsdPaymentProcessor {
        private final InrBankGateway gateway;
        CurrencyAdapter(InrBankGateway g) { this.gateway = g; }
        public void payInUsd(double dollars) { gateway.processRupees(dollars * 84.0); }
    }
    public static void main(String[] args) {
        new CurrencyAdapter(new InrBankGateway()).payInUsd(10.0);
    }
}
