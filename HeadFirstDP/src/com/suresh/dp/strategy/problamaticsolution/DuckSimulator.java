package com.suresh.dp.strategy.problamaticsolution;

public class DuckSimulator {
    public static void main(String[] args) {
        MallardDuck mallard = new MallardDuck();
        RubberDuck rubberDuck = new RubberDuck();
        DecoyDuck decoy = new DecoyDuck();

        System.out.println("MallardDuck:");
        mallard.fly();
        mallard.quack();

        System.out.println("\nRubberDuck:");
        rubberDuck.quack();

        System.out.println("\nDecoyDuck:");
        // DecoyDuck has no behavior methods
    }
}
