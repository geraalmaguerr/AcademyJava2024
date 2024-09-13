import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WeatherStationTest {
    private WeatherStation weatherStation;
    private Display display;
    private MobileApp mobileApp;
    private WebApp webApp;

    @BeforeEach
    public void setUp() {
        weatherStation = new WeatherStation();
        display = new Display();
        mobileApp = new MobileApp();
        webApp = new WebApp();
    }

    @Test
    public void testRegisterObserver() {
        weatherStation.registerObserver(display);
        weatherStation.registerObserver(mobileApp);
        weatherStation.registerObserver(webApp);

        System.out.println("Observers registered: " + weatherStation.observers.size());
        assertEquals(3, weatherStation.observers.size());
    }

    @Test
    public void testRemoveObserver() {
        weatherStation.registerObserver(display);
        weatherStation.registerObserver(mobileApp);
        
        // Remove one observer
        weatherStation.removeObserver(mobileApp);

        // Print the number of observers after removal
        System.out.println("Observers after removal: " + weatherStation.observers.size());
        
        // Assert that only one observer remains
        assertEquals(1, weatherStation.observers.size());
    }

    @Test
    public void testNotifyObservers() {
        Display displaySpy = new Display() {
            @Override
            public void update(WeatherData weatherData) {
                super.update(weatherData);
                System.out.println("Update received with temperature: " + weatherData.getTemperature());
                assertEquals(25.5, weatherData.getTemperature());
                assertEquals(65.0, weatherData.getHumidity());
                assertEquals(1013.0, weatherData.getPressure());
            }
        };

        weatherStation.registerObserver(displaySpy);
        weatherStation.setWeatherData(new WeatherData(25.5, 65.0, 1013.0));
    }

    @Test
    public void testWeatherDataUpdate() {
        WeatherData weatherData = new WeatherData(30.0, 80.0, 1008.0);
        weatherStation.setWeatherData(weatherData);

        System.out.println("Weather data updated: " +
                "Temperature = " + weatherData.getTemperature() +
                ", Humidity = " + weatherData.getHumidity() +
                ", Pressure = " + weatherData.getPressure());

        assertEquals(30.0, weatherData.getTemperature());
        assertEquals(80.0, weatherData.getHumidity());
        assertEquals(1008.0, weatherData.getPressure());
    }

    @Test
    public void testMultipleUpdates() {
        weatherStation.registerObserver(display);
        weatherStation.registerObserver(mobileApp);
        
        WeatherData firstUpdate = new WeatherData(20.0, 60.0, 1015.0);
        weatherStation.setWeatherData(firstUpdate);
        System.out.println("First update sent: " + firstUpdate.getTemperature());

        WeatherData secondUpdate = new WeatherData(22.5, 65.0, 1012.0);
        weatherStation.setWeatherData(secondUpdate);
        System.out.println("Second update sent: " + secondUpdate.getTemperature());
    }
}
