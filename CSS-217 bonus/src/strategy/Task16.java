package strategy;

public class Task16 {
    interface CompressionStrategy { String compress(String rawData); }
    static class HyphenPackStrategy implements CompressionStrategy {
        public String compress(String s) { return s.replace(' ', '-') + ".hpk"; }
    }
    static class VowelStripStrategy implements CompressionStrategy {
        public String compress(String s) { return s.replaceAll("[aeiouAEIOU]", "") + ".vzp"; }
    }
    static class ReversePackStrategy implements CompressionStrategy {
        public String compress(String s) { return new StringBuilder(s).reverse() + ".rev"; }
    }
    public static void main(String[] args) {
        String raw = "hello big world";
        CompressionStrategy[] all = { new HyphenPackStrategy(), new VowelStripStrategy(), new ReversePackStrategy() };
        for (CompressionStrategy c : all) System.out.println(c.compress(raw));
    }
}
