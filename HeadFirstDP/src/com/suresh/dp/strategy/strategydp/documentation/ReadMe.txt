Step 2: Refactor Using Strategy Design Pattern

1. Define Behavior Interfaces
These interfaces encapsulate behaviors as reusable components.

2. Create Behavior Implementations
3. Create Abstract Duck Class
4. Create Concrete Ducks
5. Test Dynamic Behavior

Advantages of the Strategy Pattern
Code Reusability: Behavior implementations (FlyWithWings, Quack) are reusable across multiple duck types.
Dynamic Changes: Behaviors can be swapped at runtime.
Avoids Behavior Explosion: No need to create a class for every combination of behaviors.
Follows SOLID Principles:
Open/Closed Principle: Add new behaviors without modifying existing ducks.
Single Responsibility Principle: Each behavior class handles only one task.
By transitioning from the interface-based approach to the Strategy Pattern, the design becomes more modular, flexible, and easier to maintain.
