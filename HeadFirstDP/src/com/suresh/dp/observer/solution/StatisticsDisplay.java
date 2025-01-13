package com.suresh.dp.observer.solution;

public class StatisticsDisplay implements Observer {
    private double minTemp = Float.MAX_VALUE;
    private double maxTemp = Float.MIN_VALUE;
    private double tempSum = 0;
    private int numReadings = 0;

    @Override
    public void update(double temperature, double humidity, double pressure) {
        tempSum += temperature;
        numReadings++;

        if (temperature > maxTemp) maxTemp = temperature;
        if (temperature < minTemp) minTemp = temperature;

        display();
    }

    public void display() {
        System.out.println("Avg/Max/Min temperature = " +
                (tempSum / numReadings) + "/" + maxTemp + "/" + minTemp);
    }
}
