package strategy;

public class Task10 {
    interface ValidationStrategy { boolean isValid(String password); }
    static class LengthValidator implements ValidationStrategy {
        public boolean isValid(String p) { return p.length() >= 8; }
    }
    static class DigitValidator implements ValidationStrategy {
        public boolean isValid(String p) {
            for (char c : p.toCharArray()) if (c >= '0' && c <= '9') return true;
            return false;
        }
    }
    static class NoSpaceValidator implements ValidationStrategy {
        public boolean isValid(String p) { return p.indexOf(' ') < 0; }
    }
    public static void main(String[] args) {
        ValidationStrategy[] all = { new LengthValidator(), new DigitValidator(), new NoSpaceValidator() };
        for (String pw : new String[]{"abc", "password1", "pass word 12"})
            for (ValidationStrategy v : all)
                System.out.println("\"" + pw + "\" " + v.getClass().getSimpleName() + ": " + v.isValid(pw));
    }
}
