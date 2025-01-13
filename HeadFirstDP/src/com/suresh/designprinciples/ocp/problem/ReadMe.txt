Suppose we are building a notification system in Java, you only need to send email/sms notifications. You will implement it like this.

Problems with this approach:

Violation of OCP:
-----------------
Every time a new notification type(e.g, Push Notification) as added, you must modify the sendNotification method. this makes the class prone to bugs.

Reduced maintainability:
------------------------
Adding new functionality requires modifying existing code, which increases the risk of breaking the existing features.

Rigid design:
------------

The class is tightly coupled to specific notification types, making it harder to scale.