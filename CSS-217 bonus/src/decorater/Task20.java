package decorater;

public class Task20 {
    interface Membership { String getPerks(); double getMonthlyFee(); }
    static class BasicGymAccess implements Membership {
        public String getPerks() { return "Gym Floor"; }
        public double getMonthlyFee() { return 1000.0; }
    }
    static abstract class MembershipDecorator implements Membership {
        protected final Membership wrapped;
        MembershipDecorator(Membership m) { this.wrapped = m; }
    }
    static class PoolAccessDecorator extends MembershipDecorator {
        PoolAccessDecorator(Membership m) { super(m); }
        public String getPerks() { return wrapped.getPerks() + ", Pool"; }
        public double getMonthlyFee() { return wrapped.getMonthlyFee() + 400.0; }
    }
    static class SaunaDecorator extends MembershipDecorator {
        SaunaDecorator(Membership m) { super(m); }
        public String getPerks() { return wrapped.getPerks() + ", Sauna"; }
        public double getMonthlyFee() { return wrapped.getMonthlyFee() + 250.0; }
    }
    static class PersonalTrainerDecorator extends MembershipDecorator {
        PersonalTrainerDecorator(Membership m) { super(m); }
        public String getPerks() { return wrapped.getPerks() + ", Personal Trainer"; }
        public double getMonthlyFee() { return wrapped.getMonthlyFee() + 1500.0; }
    }
    public static void main(String[] args) {
        Membership m = new PersonalTrainerDecorator(new SaunaDecorator(new PoolAccessDecorator(new BasicGymAccess())));
        System.out.println(m.getPerks() + " = " + m.getMonthlyFee());
    }
}
