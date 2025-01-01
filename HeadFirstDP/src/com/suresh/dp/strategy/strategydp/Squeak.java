package com.suresh.dp.strategy.strategydp;

public class Squeak implements QuackBehaviour {
    @Override
    public void quack() {
        System.out.println("Squeaking!");
    }
}
