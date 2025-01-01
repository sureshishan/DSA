package com.suresh.dp.strategy.problamaticsolution;

public class MallardDuck implements Flyable, Quackable {
    @Override
    public void fly() {
        System.out.println("MallardDuck is flying!");
    }

    @Override
    public void quack() {
        System.out.println("MallardDuck is quacking!");
    }
}
