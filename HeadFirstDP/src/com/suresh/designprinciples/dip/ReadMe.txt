DIP states that:
High level modules should not depend on low level modules, both should depend on abstractions.
Abstractions should not depend on details.
Details should depend on abstractions.

This principle promotes decoupling between high level and low level modules by relying on abstractions instead of concrete implementations.


Understanding the DIP:
1) High level modules: Classes that define business rules or core functionality of the application.
2) Low level modules: Classes that deal with specific implementation details, such as database access or external APIs
3) Abstractions: Interfaces or abstract classes that define the contract between high level and low level modules.

The goal is to reduce tight coupling, making the system more flexible, reusable and testable.