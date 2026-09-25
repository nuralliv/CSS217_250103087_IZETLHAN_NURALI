package task04;

public class Main {
    public static void main(String[] args) {
        ClockAdapter clock = new ClockAdapter(new LegacyClock());
        System.out.println("Current date (UTC): " + clock.getCurrentDate());
    }
}
