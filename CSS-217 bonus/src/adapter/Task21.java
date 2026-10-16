package adapter;

public class Task21 {
    interface CsvExporter { String exportCsv(); }
    static class ArrayDataStore {
        String[] fetchWords() { return new String[]{"apple", "banana", "cherry"}; }
    }
    static class ArrayToCsvAdapter implements CsvExporter {
        private final ArrayDataStore store;
        ArrayToCsvAdapter(ArrayDataStore s) { this.store = s; }
        public String exportCsv() { return String.join(",", store.fetchWords()); }
    }
    public static void main(String[] args) {
        System.out.println(new ArrayToCsvAdapter(new ArrayDataStore()).exportCsv());
    }
}
