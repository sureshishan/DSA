package com.suresh.dp.strategy.problamaticsolution.driver;

import com.suresh.dp.strategy.problamaticsolution.inter.impl.DecoyDuck;
import com.suresh.dp.strategy.problamaticsolution.inter.impl.MallardDuck;
import com.suresh.dp.strategy.problamaticsolution.inter.impl.RubberDuck;

public class DuckSimulator {
    public static void main(String[] args) {
        MallardDuck mallard = new MallardDuck();
        RubberDuck rubberDuck = new RubberDuck();
        DecoyDuck decoy = new DecoyDuck();

        System.out.println("MallardDuck:");
        mallard.fly();
        mallard.quack();

        System.out.println("\nRubberDuck:");
        rubberDuck.quack();

        System.out.println("\nDecoyDuck:");
        // DecoyDuck has no behavior methods
    }
}
