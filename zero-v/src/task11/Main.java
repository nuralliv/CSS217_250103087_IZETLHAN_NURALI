package task11;

public class Main {
    public static void main(String[] args) {
        BoxAdapter box = new BoxAdapter(new MetricBox(30, 20));
        System.out.println("Width (in): " + box.getWidthInches());
        System.out.println("Height (in): " + box.getHeightInches());
        System.out.println("Area (sq in): " + box.getAreaSquareInches());
    }
}
