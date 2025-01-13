To follow OCP, we should avoid modifying the existing NotificationService class when new notification types are intorduced.
Instead we can extend its behaviour using polymorphism and abstraction.

Step 1: Define an abstraction
create an interface or an abstract class to define a contract for sending notifications.

Step 2: Create Concrete Implementations
implement the Notification interface for each type of Notification

Step 3:
Use Polymorphism in the service:
Refactor the NotificationService to use the Notification interface

Step 4:
Add new Notification Types without modifying the existing code

Step 5:
Use Dependency injection to provide Notification types

Advantages:
-----------
Open for extension:
Adding a new notification type only requires creating new implementation of the Notification service

Closed for modification:
NotificationService and the existing notification implementations remain unchanged.

Scalable Design:
This design is more modular and adaptable to future changes.

Conclusion:
-----------
By applying the OCP you create systems the are easier to maintain and extend.
This approach ensures that existing code is stable and reduces the risk of introducing new bugs when adding new features.
This principle is essential for building robust and scalable applications.