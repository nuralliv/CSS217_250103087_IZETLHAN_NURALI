package task02;

public class Main {
    public static void main(String[] args) {
        TemperatureSensorAdapter sensor = new TemperatureSensorAdapter(new FahrenheitSensor());
        System.out.println("Temperature in Celsius: " + sensor.getTemperatureInCelsius());
    }
}
