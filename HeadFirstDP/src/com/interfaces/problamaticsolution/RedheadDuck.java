package com.interfaces.problamaticsolution;

public class RedheadDuck implements Flyable, Quackable{
    @Override
    public void fly() {
        System.out.println("RedheadDuck is flying!");
    }

    @Override
    public void quack() {
        System.out.println("RedheadDuck is quacking!");
    }
}
