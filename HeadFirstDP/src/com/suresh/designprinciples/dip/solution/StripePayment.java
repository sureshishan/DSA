package com.suresh.designprinciples.dip.solution;

public class StripePayment implements PaymentGateway {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing payment of $" + amount + "through Stripe");
    }
}
