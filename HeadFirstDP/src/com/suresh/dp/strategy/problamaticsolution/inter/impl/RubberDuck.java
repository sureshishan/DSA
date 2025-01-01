package com.suresh.dp.strategy.problamaticsolution.inter.impl;

import com.suresh.dp.strategy.problamaticsolution.inter.Quackable;

public class RubberDuck implements Quackable {
    @Override
    public void quack() {
        System.out.println("RubberDuck is squeaking!");
    }
}
