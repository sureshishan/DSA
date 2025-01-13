package com.suresh.dp.observer.problematic;

public class CurrentConditionsDisplay {
    private double temperature;
    private double humidity;

    public void update(double temperature, double humidity, double pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        display();
    }

    private void display() {
        System.out.println("Current conditions: " + temperature + "F degrees and " + humidity + "% humidity");
    }
}
