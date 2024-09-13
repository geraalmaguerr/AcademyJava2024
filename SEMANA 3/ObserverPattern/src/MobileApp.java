public class MobileApp implements Observer {
    @Override
    public void update(WeatherData weatherData) {
        System.out.println("Mobile App updated: " +
                "Temperature = " + weatherData.getTemperature() +
                ", Humidity = " + weatherData.getHumidity() +
                ", Pressure = " + weatherData.getPressure());
    }
}
