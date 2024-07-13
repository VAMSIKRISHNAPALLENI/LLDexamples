package org.practice;
import org.practice.builderpattern.pizza.MakePizza;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(
        scanBasePackages = {"org.practice"}
)
public class Main {
    public static void main(String[] args) {
        System.out.println("Low Level Design");
        /*----------------Chain Of Responsibility-------------------*/
        LowLevelDesign lowLevelDesign = new LowLevelDesign();
        lowLevelDesign.testForCOR();
        /*-----------Builder Pattern---------------------------*/
        MakePizza makePizza = new MakePizza();
        makePizza.buildPizza();
        /*------------Decorator Pattern------------------------*/

    }
}
