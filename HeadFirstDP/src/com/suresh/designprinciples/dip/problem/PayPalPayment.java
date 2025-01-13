package com.suresh.designprinciples.dip.problem;

public class PayPalPayment {
    public void processPayment(double amount) {
        System.out.println("Processing payment of $" + amount + "through Paypal");
    }
}
