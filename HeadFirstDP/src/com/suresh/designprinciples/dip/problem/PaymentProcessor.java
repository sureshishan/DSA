package com.suresh.designprinciples.dip.problem;

public class PaymentProcessor {
    private PayPalPayment payPalPayment;

    public PaymentProcessor() {
        this.payPalPayment = new PayPalPayment();
    }

    public void processPayment(double amount) {
        payPalPayment.processPayment(amount);
    }
}
