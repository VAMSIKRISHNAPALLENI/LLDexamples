package org.practice.builderpattern.pizza.builder;

import org.practice.builderpattern.pizza.entity.Pizza;
import org.practice.builderpattern.pizza.enums.CrustTypeEnum;
import org.practice.builderpattern.pizza.enums.SizeEnum;
import org.practice.builderpattern.pizza.enums.ToppingEnum;

import java.util.HashSet;

public class PizzaBuilder {
    private SizeEnum size;
    private CrustTypeEnum crustType;
    private HashSet<ToppingEnum> toppings= new HashSet<>();

    public PizzaBuilder setSize(SizeEnum size) {
        this.size = size;
        return this;
    }

    public PizzaBuilder setCrustType(CrustTypeEnum crustType) {
        this.crustType = crustType;
        return this;
    }

    public PizzaBuilder addToppings(ToppingEnum topping) {
        this.toppings.add(topping);
        return this;
    }

    public Pizza buildPizza(){
        return new Pizza(this.size, this.crustType, this.toppings);
    }
}
