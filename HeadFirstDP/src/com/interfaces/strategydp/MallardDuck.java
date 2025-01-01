package com.interfaces.strategydp;

public class MallardDuck extends Duck {

    MallardDuck() {
        super(new FlyWithWings(), new Quack());
    }

    @Override
    public void display() {
        System.out.println("I'm a Mallard Duck!");
    }
}
