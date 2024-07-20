package org.practice.decoratorpattern.pizza_example.toppings;

import org.practice.decoratorpattern.pizza_example.Pizza;

import java.security.PublicKey;

public class Cheese extends Toppings{
    Pizza pizza;
    public Cheese(Pizza pizza){
        this.pizza=pizza;
    }
    @Override
    public int getPrize() {
        return pizza.getPrize()+2;
    }

    @Override
    public String getpizzaDisc() {
        return pizza.getpizzaDisc()+", Cheese";
    }
}
