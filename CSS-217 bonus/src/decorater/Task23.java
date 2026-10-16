package decorater;

public class Task23 {
    interface FormattedText { String render(); }
    static class SimpleText implements FormattedText {
        private final String text;
        SimpleText(String text) { this.text = text; }
        public String render() { return text; }
    }
    static abstract class TagDecorator implements FormattedText {
        protected final FormattedText wrapped;
        TagDecorator(FormattedText f) { this.wrapped = f; }
    }
    static class BoldTagDecorator extends TagDecorator {
        BoldTagDecorator(FormattedText f) { super(f); }
        public String render() { return "[B]" + wrapped.render() + "[/B]"; }
    }
    static class ItalicTagDecorator extends TagDecorator {
        ItalicTagDecorator(FormattedText f) { super(f); }
        public String render() { return "[I]" + wrapped.render() + "[/I]"; }
    }
    static class CodeTagDecorator extends TagDecorator {
        CodeTagDecorator(FormattedText f) { super(f); }
        public String render() { return "[CODE]" + wrapped.render() + "[/CODE]"; }
    }
    public static void main(String[] args) {
        FormattedText t = new CodeTagDecorator(new ItalicTagDecorator(new BoldTagDecorator(new SimpleText("hello"))));
        System.out.println(t.render());
    }
}
