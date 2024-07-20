package org.practice.decoratorpattern.pizza_example.pizzastyle;

import org.practice.decoratorpattern.pizza_example.Pizza;

public class FarmHouse extends Pizza {
    public FarmHouse() {
        pizzaDisc="A Fresh Farm House Pizza with";
    }

    @Override
    public int getPrize() {
        return 250;
    }
}
