Solution:
To follow DIP we need to,

1)Introduce an Abstraction: Define common interface for all payment gateways
2) Depend on Abstraction: Make PaymentProcessor depend on the abstraction, not on concrete implementations.
3) Inject Dependencies: Use dependency injection to provide the required implementation

Benefits:
---------

Reduced coupling:
-----------------
The PaymentProcessor does not depend on concrete implementations.
It depends on abstraction (PaymentGateway), making it easy to switch between payment gateways.

Improved Testability:
---------------------
You can easily mock the PaymentGateway interface for testing

Extensibility:
--------------
Adding new PaymentGateway (e.g., RazorPay) only requires implementing the paymentGateway interface.
The PaymentProcessor does not need to be modified.

Flexibility:
------------
The system become more adaptable to changes in low level modules.

Conclusion:
-----------
1) High level modules focus only on business logic and not burdened with implementation details.
2) Low level modules become interchangeable and reusable by adhering to the same abstraction.
3) The system is easier to maintain, extend and test, leading to better software quality.



