package com.interfaces.strategydp;

public class DuckSimulator {
    public static void main(String[] args) {
        Duck mallard = new MallardDuck();
        mallard.display();
        mallard.performFly();
        mallard.performQuack();

        // Change behavior dynamically
        mallard.setFlyingBehaviour(new FlyNoWay());

        Duck rubber = new RubberDuck();
        rubber.display();
        rubber.performFly();
        rubber.performQuack();
    }
}
