package com.suresh.dp.strategy.strategydp.duck;

import com.suresh.dp.strategy.strategydp.behaviours.impl.FlyWithWings;
import com.suresh.dp.strategy.strategydp.behaviours.impl.Quack;
import com.suresh.dp.strategy.strategydp.duck.Duck;

public class MallardDuck extends Duck {

    MallardDuck() {
        super(new FlyWithWings(), new Quack());
    }

    @Override
    public void display() {
        System.out.println("I'm a Mallard Duck!");
    }
}
