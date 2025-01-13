Problems:
Tight coupling: The PaymentProcessor tightly coupled to PaypalPayment. If the payment gateway changes (e.g., to Stripe), you must modify the PaymentProcessor

Reduced testability:
Testing PaymentProcessor is difficult because you cannot replace PayPalPayment with a mock or alternative implementation

Violation of DIP:
High level module(Payment Processor) directly depending on low level module(PayPalPayment) instead of abstraction.

