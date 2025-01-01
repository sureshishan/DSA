package com.suresh.dp.strategy.strategydp.behaviours.impl;

import com.suresh.dp.strategy.strategydp.behaviours.FlyingBehaviour;

public class FlyWithWings implements FlyingBehaviour {
    @Override
    public void fly() {
        System.out.println("Flying with wings!");
    }
}
