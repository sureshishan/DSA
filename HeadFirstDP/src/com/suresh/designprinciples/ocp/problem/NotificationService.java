package com.suresh.designprinciples.ocp.problem;

public class NotificationService {
    public void sendNotification(String type, String message) {
        if (type.equalsIgnoreCase("EMAIL"))
            System.out.println("Sending EMAIL: " + message);
        else if (type.equalsIgnoreCase("SMS")) {
            System.out.println("Sending SMS: " + message);
        }
    }
}
