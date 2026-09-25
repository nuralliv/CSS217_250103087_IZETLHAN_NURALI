package task18;

public class Main {
    public static void main(String[] args) {
        ThrottledApiAdapter api = new ThrottledApiAdapter(new ThirdPartyApiServer());

        long start = System.currentTimeMillis();
        System.out.println("Call 1: " + api.getProtectedData());
        System.out.println("Call 2: " + api.getProtectedData());
        long elapsed = System.currentTimeMillis() - start;

        System.out.println("Elapsed ms (should be >= 200): " + elapsed);
    }
}
