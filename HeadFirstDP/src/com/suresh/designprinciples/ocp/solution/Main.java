package com.suresh.designprinciples.ocp.solution;

public class Main {
    public static void main(String[] args) {
        Notification emailNotification = new EmailNotification();
        Notification smsNotification = new SMSNotification();
        NotificationService notificationService = new NotificationService(emailNotification);
        notificationService.setNotification(smsNotification);
        notificationService.sendNotification("Suresh");
    }
}
