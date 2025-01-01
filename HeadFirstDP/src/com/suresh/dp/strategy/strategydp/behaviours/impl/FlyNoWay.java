package com.suresh.dp.strategy.strategydp.behaviours.impl;

import com.suresh.dp.strategy.strategydp.behaviours.FlyingBehaviour;

public class FlyNoWay implements FlyingBehaviour {

    @Override
    public void fly() {
        System.out.println("Can't fly");
    }
}
