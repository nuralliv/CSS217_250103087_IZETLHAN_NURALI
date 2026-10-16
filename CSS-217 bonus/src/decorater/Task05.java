package decorater;

public class Task05 {
    interface TextComponent { String format(String input); }
    static class PlainText implements TextComponent {
        public String format(String input) { return input; }
    }
    static abstract class TextDecorator implements TextComponent {
        protected final TextComponent wrapped;
        TextDecorator(TextComponent c) { this.wrapped = c; }
    }
    static class UpperCaseDecorator extends TextDecorator {
        UpperCaseDecorator(TextComponent c) { super(c); }
        public String format(String in) { return wrapped.format(in).toUpperCase(); }
    }
    static class TrimDecorator extends TextDecorator {
        TrimDecorator(TextComponent c) { super(c); }
        public String format(String in) { return wrapped.format(in).trim(); }
    }
    static class BracketDecorator extends TextDecorator {
        BracketDecorator(TextComponent c) { super(c); }
        public String format(String in) { return "[" + wrapped.format(in) + "]"; }
    }
    public static void main(String[] args) {
        TextComponent t = new BracketDecorator(new UpperCaseDecorator(new TrimDecorator(new PlainText())));
        System.out.println(t.format("   hello world  "));
    }
}
