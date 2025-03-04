package com.suresh.designprinciples.ocp.problem

public class SMSNotification {
  public void send(String message) {
    System.out.println("Sending SMS Notification" + message);
  }
}
