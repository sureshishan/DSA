package com.suresh.dp.strategy.problamaticsolution.inter.impl;

import com.suresh.dp.strategy.problamaticsolution.inter.Flyable;
import com.suresh.dp.strategy.problamaticsolution.inter.Quackable;

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
