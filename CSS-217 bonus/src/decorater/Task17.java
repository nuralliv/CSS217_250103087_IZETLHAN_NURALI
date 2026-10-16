package decorator;

public class Task17 {
    interface DataSource { String readData(); }
    static class RawStringSource implements DataSource {
        public String readData() { return "confidential_payload"; }
    }
    static abstract class DataDecorator implements DataSource {
        protected final DataSource wrapped;
        DataDecorator(DataSource d) { this.wrapped = d; }
    }
    static class ReverseCipherDecorator extends DataDecorator {
        ReverseCipherDecorator(DataSource d) { super(d); }
        public String readData() { return new StringBuilder(wrapped.readData()).reverse().toString(); }
    }
    static class ShiftCipherDecorator extends DataDecorator {
        ShiftCipherDecorator(DataSource d) { super(d); }
        public String readData() {
            StringBuilder sb = new StringBuilder();
            for (char c : wrapped.readData().toCharArray()) sb.append((char) (c + 1));
            return sb.toString();
        }
    }
    static class HeaderDecorator extends DataDecorator {
        HeaderDecorator(DataSource d) { super(d); }
        public String readData() { return "SEC_HEADER:" + wrapped.readData(); }
    }
    public static void main(String[] args) {
        DataSource d = new HeaderDecorator(new ShiftCipherDecorator(new ReverseCipherDecorator(new RawStringSource())));
        System.out.println(d.readData());
    }
}
