package com.suresh.designprinciples.ocp.problem;

public class Main {
    public static void main(String[] args) {
        NotificationService notificationService = new NotificationService();
        notificationService.sendNotification("Email", "Suresh");
        notificationService.sendNotification("SMS", "Suresh");
    }
}
