package com.suresh.designprinciples.ocp.problem

public class SmsNotification {
  public void send(String message) {
    System.out.println("Sending SMS:" + message);
  }
}
