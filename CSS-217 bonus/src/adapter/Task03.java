package adapter;

public class Task03 {
    interface CelsiusThermometer { double getTemperatureC(); }
    static class FahrenheitSensor { double readFahrenheit() { return 98.6; } }
    static class SensorAdapter implements CelsiusThermometer {
        private final FahrenheitSensor sensor;
        SensorAdapter(FahrenheitSensor s) { this.sensor = s; }
        public double getTemperatureC() { return (sensor.readFahrenheit() - 32.0) * 5.0 / 9.0; }
    }
    public static void main(String[] args) {
        CelsiusThermometer t = new SensorAdapter(new FahrenheitSensor());
        System.out.printf("%.2f C%n", t.getTemperatureC());
    }

}
