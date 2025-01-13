package com.suresh.dp.observer.solution;

import java.util.ArrayList;
import java.util.List;

public class WeatherData implements Subject {
    List<Observer> observerList;
    private double temperature;
    private double humidity;
    private double pressure;

    public WeatherData() {
        this.observerList = new ArrayList<>();
    }


    @Override
    public void registerObserver(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observerList) {
            observer.update(temperature, humidity, pressure);
        }
    }

    public void setMeasurements(double temperature, double humidity, double pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        notifyObservers();
    }
}
