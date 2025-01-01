package com.interfaces.strategydp;

public abstract class Duck {
    private FlyingBehaviour flyingBehaviour;
    private QuackBehaviour quackBehaviour;

    public Duck(FlyingBehaviour flyingBehaviour, QuackBehaviour quackBehaviour) {
        this.flyingBehaviour = flyingBehaviour;
        this.quackBehaviour = quackBehaviour;
    }

    public void performFly() {
        flyingBehaviour.fly();
        ;
    }

    public void performQuack() {
        quackBehaviour.quack();
    }

    public void setFlyingBehaviour(FlyingBehaviour flyingBehaviour) {
        this.flyingBehaviour = flyingBehaviour;
    }

    public void setQuackBehaviour(QuackBehaviour quackBehaviour) {
        this.quackBehaviour = quackBehaviour;
    }

    public abstract void display();
}
