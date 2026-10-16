package adapter;

public class Task15 {
    interface CartesianPoint { double getX(); double getY(); }
    static class PolarPoint {
        private final double r, theta;
        PolarPoint(double r, double theta) { this.r = r; this.theta = theta; }
        double getRadius() { return r; }
        double getAngleRadians() { return theta; }
    }
    static class PolarToCartesianAdapter implements CartesianPoint {
        private final PolarPoint p;
        PolarToCartesianAdapter(PolarPoint p) { this.p = p; }
        public double getX() { return p.getRadius() * Math.cos(p.getAngleRadians()); }
        public double getY() { return p.getRadius() * Math.sin(p.getAngleRadians()); }
    }
    public static void main(String[] args) {
        CartesianPoint c = new PolarToCartesianAdapter(new PolarPoint(2.0, Math.PI / 3));
        System.out.printf("(%.4f, %.4f)%n", c.getX(), c.getY());
    }
}
