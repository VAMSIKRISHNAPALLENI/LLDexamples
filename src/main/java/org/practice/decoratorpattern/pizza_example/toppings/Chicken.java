package org.practice.decoratorpattern.pizza_example.toppings;

import org.practice.decoratorpattern.pizza_example.Pizza;

public class Chicken extends Toppings {
    Pizza pizza;
    public Chicken(Pizza pizza){
        this.pizza=pizza;
    }

    @Override
    public int getPrize() {
        return pizza.getPrize()+10;
    }

    @Override
    public String getpizzaDisc() {
        return pizza.getpizzaDisc()+", Chicken";
    }
}