package strategy;

import java.util.Arrays;
public class Task04 {
    interface SortStrategy { void sort(int[] data); }
    static class BubbleSortStrategy implements SortStrategy {
        public void sort(int[] a) {
            for (int i = 0; i < a.length - 1; i++)
                for (int j = 0; j < a.length - 1 - i; j++)
                    if (a[j] > a[j + 1]) { int t = a[j]; a[j] = a[j + 1]; a[j + 1] = t; }
        }
    }
    static class SelectionSortStrategy implements SortStrategy {
        public void sort(int[] a) {
            for (int i = 0; i < a.length - 1; i++) {
                int min = i;
                for (int j = i + 1; j < a.length; j++) if (a[j] < a[min]) min = j;
                int t = a[i]; a[i] = a[min]; a[min] = t;
            }
        }
    }
    static class InsertionSortStrategy implements SortStrategy {
        public void sort(int[] a) {
            for (int i = 1; i < a.length; i++) {
                int key = a[i], j = i - 1;
                while (j >= 0 && a[j] > key) { a[j + 1] = a[j]; j--; }
                a[j + 1] = key;
            }
        }
    }
    static class DataProcessor {
        private SortStrategy strategy;
        DataProcessor(SortStrategy s) { this.strategy = s; }
        void setStrategy(SortStrategy s) { this.strategy = s; }
        void process(int[] data) {
            strategy.sort(data);
            System.out.println(Arrays.toString(data));
        }
    }
    public static void main(String[] args) {
        DataProcessor p = new DataProcessor(new BubbleSortStrategy());
        p.process(new int[]{5, 2, 9, 1, 7});
        p.setStrategy(new SelectionSortStrategy());
        p.process(new int[]{5, 2, 9, 1, 7});
        p.setStrategy(new InsertionSortStrategy());
        p.process(new int[]{5, 2, 9, 1, 7});
    }
}
