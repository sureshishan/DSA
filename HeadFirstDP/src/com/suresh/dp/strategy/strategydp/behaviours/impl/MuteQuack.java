package com.suresh.dp.strategy.strategydp.behaviours.impl;

import com.suresh.dp.strategy.strategydp.behaviours.QuackBehaviour;

public class MuteQuack implements QuackBehaviour {
    @Override
    public void quack() {
        System.out.println("<< Silence >>");
    }
}
