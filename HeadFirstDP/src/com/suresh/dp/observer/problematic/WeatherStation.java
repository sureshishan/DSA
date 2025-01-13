package com.suresh.dp.observer.problematic;

public class WeatherStation {
    public static void main(String[] args) {
        //Instantiating specific observers
        CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay();
        StatisticsDisplay statisticsDisplay = new StatisticsDisplay();

        // Passing observers directly to WeatherData
        WeatherData weatherData = new WeatherData(currentConditionsDisplay, statisticsDisplay);

        // Simulating new measurements
        weatherData.setMeasurements(80, 65, 30.4f);
        weatherData.setMeasurements(82, 70, 29.2f);
        weatherData.setMeasurements(78, 90, 29.2f);
    }
}
