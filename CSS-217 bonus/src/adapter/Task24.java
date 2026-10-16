package adapter;

public class Task24 {
    interface AppLogger { void log(String level, String message); }
    static class ConsoleWriter {
        void writeLine(String fullText) { System.out.println(fullText); }
    }
    static class LoggerAdapter implements AppLogger {
        private final ConsoleWriter writer;
        LoggerAdapter(ConsoleWriter w) { this.writer = w; }
        public void log(String level, String message) {
            writer.writeLine("[" + level.toUpperCase() + "] " + message);
        }
    }
    public static void main(String[] args) {
        AppLogger l = new LoggerAdapter(new ConsoleWriter());
        l.log("info", "Started");
        l.log("error", "Something failed");
    }
}
