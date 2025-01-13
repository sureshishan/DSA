package com.suresh.dp.observer.solution;

public class CurrentConditionsDisplay implements Observer {
    private double temperature;
    private double humidity;

    @Override
    public void update(double temperature, double humidity, double pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        display();
    }

    public void display() {
        System.out.println("Current conditions: " + temperature + "F degrees and " + humidity + "% humidity");
    }
}
