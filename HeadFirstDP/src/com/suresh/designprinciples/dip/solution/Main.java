package com.suresh.designprinciples.dip.solution;

public class Main {
    public static void main(String[] args) {
        PaymentGateway payPalPayment = new PayPalPayment();
        PaymentProcessor payPalProcessor = new PaymentProcessor(payPalPayment);
        payPalProcessor.processPayment(100.0);

        PaymentGateway stripePayment = new PayPalPayment();
        PaymentProcessor stripeProcessor = new PaymentProcessor(payPalPayment);
        stripeProcessor.processPayment(200.0);
    }
}
