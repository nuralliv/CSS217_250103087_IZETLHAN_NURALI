package strategy;

import java.util.Arrays;
public class Task25 {
    interface PixelFilterStrategy { int[] applyFilter(int[] pixels); }
    static class InvertStrategy implements PixelFilterStrategy {
        public int[] applyFilter(int[] px) {
            int[] r = new int[px.length];
            for (int i = 0; i < px.length; i++) r[i] = 255 - px[i];
            return r;
        }
    }
    static class ThresholdStrategy implements PixelFilterStrategy {
        public int[] applyFilter(int[] px) {
            int[] r = new int[px.length];
            for (int i = 0; i < px.length; i++) r[i] = px[i] >= 128 ? 255 : 0;
            return r;
        }
    }
    static class BrightenStrategy implements PixelFilterStrategy {
        public int[] applyFilter(int[] px) {
            int[] r = new int[px.length];
            for (int i = 0; i < px.length; i++) r[i] = Math.min(255, px[i] + 30);
            return r;
        }
    }
    public static void main(String[] args) {
        int[] pixels = {0, 100, 128, 200, 250};
        PixelFilterStrategy[] all = { new InvertStrategy(), new ThresholdStrategy(), new BrightenStrategy() };
        for (PixelFilterStrategy f : all)
            System.out.println(f.getClass().getSimpleName() + ": " + Arrays.toString(f.applyFilter(pixels)));
    }
}
