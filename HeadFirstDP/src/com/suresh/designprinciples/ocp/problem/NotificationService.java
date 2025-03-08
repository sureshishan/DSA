package com.suresh.designprinciples.ocp.problem;

public class NotificationService {
    public void sendNotification(String type, String message) {
        if (type.equalsIgnoreCase("EMAIL"))
            EmailNotification emailNotification = new EmailNotification();
            emailNotification.send(message);
        else if (type.equalsIgnoreCase("SMS")) {
            SmsNotification smsNotification = new SmsNotification();
            pushNotification.send(message);
        } else if (type.equalsIgnoreCase("PUSH")) {
            PushNotification pushNotification = new PushNotification();
            System.out.println("Sending SMS: " + message);
        }
    }
}
