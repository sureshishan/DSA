package com.suresh.designprinciples.ocp.problem

public class EmailNotification {
  public void send(String message) {
    System.out.println("Sending Email:" + message);
  }
}
