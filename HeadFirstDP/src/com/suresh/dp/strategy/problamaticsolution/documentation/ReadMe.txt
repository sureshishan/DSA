Issues with the Interface-Based Approach
========================================

1. Code Duplication Across Classes
Problem: The behavior (e.g., flying or quacking) is duplicated in every duck class that implements these interfaces.
For example, both MallardDuck and another duck like RedheadDuck will have identical implementations of the fly() method. This leads to repetition and violates the DRY (Don't Repeat Yourself) principle.

Example Duplication:

java
Copy code
class RedheadDuck implements Flyable, Quackable {
    @Override
    public void fly() {
        System.out.println("RedheadDuck is flying!"); // Same as MallardDuck
    }

    @Override
    public void quack() {
        System.out.println("RedheadDuck is quacking!"); // Same as MallardDuck
    }
}
If flying behavior changes (e.g., introduce a "Glide" behavior), you must manually update multiple classes.

============================================================================================================

2. Inflexibility in Behavior Changes
Problem: A duck's behavior is tightly coupled to the class definition and cannot change dynamically at runtime.
For example, if a MallardDuck is injured and cannot fly anymore, you cannot change its behavior without modifying the class itself.
Example Issue:

java
Copy code
MallardDuck mallard = new MallardDuck();
mallard.fly(); // "MallardDuck is flying!"

// You cannot dynamically make the mallard stop flying without modifying the MallardDuck class.

==========================================================================================================

3. Behavior Explosion
Problem: As new behaviors are introduced, you must create more interfaces or combinations of them, leading to class explosion.
For example, adding swimming behavior might require:
Swimmable interface
Classes that implement combinations like Flyable, Quackable, Swimmable
Example Explosion:

java
Copy code
interface Swimmable {
    void swim();
}

class DivingDuck implements Flyable, Swimmable {
    @Override
    public void fly() {
        System.out.println("DivingDuck is flying!");
    }

    @Override
    public void swim() {
        System.out.println("DivingDuck is swimming!");
    }
}
The more behaviors you add, the more interfaces and classes you need to manage.
