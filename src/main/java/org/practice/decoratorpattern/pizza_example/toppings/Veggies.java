package org.practice.decoratorpattern.pizza_example.toppings;

import org.practice.decoratorpattern.pizza_example.Pizza;

public class Veggies extends Toppings {
    Pizza pizza;
    public Veggies(Pizza pizza){
       this.pizza=pizza;
    }

    @Override
    public int getPrize() {
        return pizza.getPrize()+5;
    }

    @Override
    public String getpizzaDisc() {
        return pizza.getpizzaDisc()+", Veggies";
    }
}
