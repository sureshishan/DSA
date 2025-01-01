package com.suresh.dp.strategy.strategydp.driver;

import com.suresh.dp.strategy.strategydp.behaviours.impl.FlyNoWay;
import com.suresh.dp.strategy.strategydp.duck.Duck;
import com.suresh.dp.strategy.strategydp.duck.MallardDuck;
import com.suresh.dp.strategy.strategydp.duck.RubberDuck;

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
