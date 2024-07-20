package org.practice.decoratorpattern.pizza_example;

public abstract class Pizza {
    public String pizzaDisc;
    public  String getpizzaDisc(){
        return pizzaDisc;
    }

    public abstract int getPrize();
}
