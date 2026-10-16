package decorater;

public class Task11 {
    interface Notifier { String send(String msg);}
    static class EmailNotifier implements Notifier {
        public String send(String msg) { return "EMAIL:" + msg; }
    }
    static abstract class NotifierDecorator implements Notifier {
        protected final Notifier wrapped;
        NotifierDecorator(Notifier n) { this.wrapped = n; }
    }
    static class SMSDecorator extends NotifierDecorator {
        SMSDecorator(Notifier n) { super(n); }
        public String send(String msg) { return wrapped.send(msg) + " | SMS: " + msg; }
    }
    static class SlackDecorator extends NotifierDecorator {
        SlackDecorator(Notifier n) { super(n); }
        public String send(String msg) { return wrapped.send(msg) + " | SLACK: " + msg; }
    }
    static class WhatsAppDecorator extends NotifierDecorator {
        WhatsAppDecorator(Notifier n) { super(n); }
        public String send(String msg) { return wrapped.send(msg) + " | WA: " + msg; }
    }
    public static void main(String[] args) {
        Notifier n = new WhatsAppDecorator(new SlackDecorator(new SMSDecorator(new EmailNotifier())));
        System.out.println(n.send("Server down"));
    }
}
