package org.practice.builderpattern.pizza.entity;

import lombok.Data;
import org.practice.builderpattern.pizza.enums.CrustTypeEnum;
import org.practice.builderpattern.pizza.enums.SizeEnum;
import org.practice.builderpattern.pizza.enums.ToppingEnum;

import java.util.HashSet;
@Data
public class Pizza {
    private SizeEnum size;
    private CrustTypeEnum crustType;
    private HashSet<ToppingEnum> toppings;

    public Pizza(SizeEnum size, CrustTypeEnum crustType, HashSet<ToppingEnum> toppings){
        this.size = size;
        this.crustType = crustType;
        this.toppings = toppings;
    }
}
