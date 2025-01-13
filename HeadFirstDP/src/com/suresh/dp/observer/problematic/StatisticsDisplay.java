package com.suresh.dp.observer.problematic;

public class StatisticsDisplay {
    private double minTemp = Double.MAX_VALUE;
    private double maxTemp = Double.MAX_VALUE;

    private double tempSum = 0;
    private int numReadings = 0;


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
