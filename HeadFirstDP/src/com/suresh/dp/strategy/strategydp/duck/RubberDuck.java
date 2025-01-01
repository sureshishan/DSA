package com.suresh.dp.strategy.strategydp.duck;

import com.suresh.dp.strategy.strategydp.behaviours.impl.FlyNoWay;
import com.suresh.dp.strategy.strategydp.behaviours.impl.Squeak;
import com.suresh.dp.strategy.strategydp.duck.Duck;

public class RubberDuck extends Duck {

    public RubberDuck() {
        super(new FlyNoWay(), new Squeak());
    }

    @Override
    public void display() {
        System.out.println("I'm a Rubber Duck!");
    }
}
