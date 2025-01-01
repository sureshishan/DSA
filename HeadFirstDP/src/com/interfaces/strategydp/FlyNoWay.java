package com.interfaces.strategydp;

public class FlyNoWay implements FlyingBehaviour {

    @Override
    public void fly() {
        System.out.println("Can't fly");
    }
}
