package task02;

public class TemperatureSensorAdapter implements ICelsiusSensor {

    private final FahrenheitSensor fahrenheitSensor;

    public TemperatureSensorAdapter(FahrenheitSensor fahrenheitSensor) {
        this.fahrenheitSensor = fahrenheitSensor;
    }

    @Override
    public double getTemperatureInCelsius() {
        String raw = fahrenheitSensor.readRawTemperature();
        String numeric = raw.trim();
        if (numeric.endsWith("F")) {
            numeric = numeric.substring(0, numeric.length() - 1).trim();
        }
        double fahrenheit = Double.parseDouble(numeric);
        double celsius = (fahrenheit - 32) * (5.0 / 9.0);
        return Math.round(celsius * 100.0) / 100.0;
    }
}
