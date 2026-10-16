package strategy;

public class Task13 {
    interface AttackStrategy { int computeDamage(int baseStrength); }
    static class MeleeAttack implements AttackStrategy {
        public int computeDamage(int b) { return b * 2; }
    }
    static class RangedAttack implements AttackStrategy {
        public int computeDamage(int b) { return b + 15; }
    }
    static class MagicAttack implements AttackStrategy {
        public int computeDamage(int b) { return b * 3 - 10; }
    }
    public static void main(String[] args) {
        AttackStrategy[] all = { new MeleeAttack(), new RangedAttack(), new MagicAttack() };
        for (AttackStrategy a : all)
            System.out.println(a.getClass().getSimpleName() + "  : " + a.computeDamage(20));
    }
}
