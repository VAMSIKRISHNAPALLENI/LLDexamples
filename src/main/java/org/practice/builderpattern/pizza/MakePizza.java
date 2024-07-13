package org.practice.builderpattern.pizza;

import lombok.extern.slf4j.Slf4j;
import org.practice.builderpattern.pizza.builder.PizzaBuilder;
import org.practice.builderpattern.pizza.entity.Pizza;
import org.practice.builderpattern.pizza.enums.CrustTypeEnum;
import org.practice.builderpattern.pizza.enums.SizeEnum;
import org.practice.builderpattern.pizza.enums.ToppingEnum;
@Slf4j
public class MakePizza {

    public void buildPizza(){
        log.info("Building pizza");
        Pizza myPizza = new PizzaBuilder()
                .setSize(SizeEnum.SMALL)
                .setCrustType(CrustTypeEnum.NEW_YORK_STYLE)
                .addToppings(ToppingEnum.CHEESE)
                .addToppings(ToppingEnum.VEGGIES)
                .buildPizza();
        log.info("Final pizza is {}",myPizza.toString());
    }
}
