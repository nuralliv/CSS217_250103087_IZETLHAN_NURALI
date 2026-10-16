package adapter;

public class Task06 {
    interface ModernPrinter { void printDocument(String text); }
    static class DotMatrixPrinter {
        void printCharArray(char[] buffer) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < buffer.length; i++) {
                if (i > 0) sb.append(' ');
                sb.append(buffer[i]);
            }
            System.out.println(sb);
        }
    }
    static class PrinterAdapter implements ModernPrinter {
        private final DotMatrixPrinter printer;
        PrinterAdapter(DotMatrixPrinter p) { this.printer = p; }
        public void printDocument(String text) { printer.printCharArray(text.toCharArray()); }
    }
    public static void main(String[] args) {
        ModernPrinter p = new PrinterAdapter(new DotMatrixPrinter());
        p.printDocument("Hello");
    }
}
