package decorater;

public class Task14 {
    interface CharacterDefense { int getArmorRating(); }
    static class BasicTunic implements CharacterDefense {
        public int getArmorRating() { return 10; }
    }
    static abstract class DefenseDecorator implements CharacterDefense {
        protected final CharacterDefense wrapped;
        DefenseDecorator(CharacterDefense d) { this.wrapped = d; }
    }
    static class IronShieldDecorator extends DefenseDecorator {
        IronShieldDecorator(CharacterDefense d) { super(d); }
        public int getArmorRating() { return wrapped.getArmorRating() + 25; }
    }
    static class HelmetDecorator extends DefenseDecorator {
        HelmetDecorator(CharacterDefense d) { super(d); }
        public int getArmorRating() { return wrapped.getArmorRating() + 15; }
    }
    static class MagicAuraDecorator extends DefenseDecorator {
        MagicAuraDecorator(CharacterDefense d) { super(d); }
        public int getArmorRating() { return wrapped.getArmorRating() * 2; }
    }
    public static void main(String[] args) {
        CharacterDefense auraLast = new MagicAuraDecorator(new HelmetDecorator(new IronShieldDecorator(new BasicTunic())));
        CharacterDefense auraFirst = new HelmetDecorator(new IronShieldDecorator(new MagicAuraDecorator(new BasicTunic())));
        System.out.println("Shield -> Helmet -> Aura: " + auraLast.getArmorRating());   // ((10+25)+15)*2 = 100
        System.out.println("Aura -> Shield -> Helmet: " + auraFirst.getArmorRating());  // (10*2)+25+15 = 60
    }
}
