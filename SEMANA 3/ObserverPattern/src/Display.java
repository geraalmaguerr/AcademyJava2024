public class Display implements Observer {
    @Override
    public void update(WeatherData weatherData) {
        System.out.println("Display updated: " +
                "Temperature = " + weatherData.getTemperature() +
                ", Humidity = " + weatherData.getHumidity() +
                ", Pressure = " + weatherData.getPressure());
    }
}
