package com.suresh.dp.strategy.strategydp;

public class FlyNoWay implements FlyingBehaviour {

    @Override
    public void fly() {
        System.out.println("Can't fly");
    }
}
