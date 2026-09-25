package task13;

public class Main {
    public static void main(String[] args) {
        SmsNotificationAdapter notifier = new SmsNotificationAdapter(new ThirdPartySmsProvider());
        notifier.notify(new AlertMessage("77001234567", "Alert", "Server is down"));

        try {
            notifier.notify(null);
        } catch (IllegalArgumentException e) {
            System.out.println("Correctly rejected null alert: " + e.getMessage());
        }
    }
}
