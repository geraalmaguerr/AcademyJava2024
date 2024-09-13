public class WebApp implements Observer {
    @Override
    public void update(WeatherData weatherData) {
        System.out.println("Web App updated: " +
                "Temperature = " + weatherData.getTemperature() +
                ", Humidity = " + weatherData.getHumidity() +
                ", Pressure = " + weatherData.getPressure());
    }
}
