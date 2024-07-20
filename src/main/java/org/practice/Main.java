package org.practice;
import org.practice.builderpattern.pizza.MakePizza;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(
        scanBasePackages = {"org.practice"}
)
public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);
    public static void main(String[] args) {
        log.info("Started Low Level Design");
        LowLevelDesign lowLevelDesign = new LowLevelDesign();
        /*----------------Chain Of Responsibility-------------------*/
        lowLevelDesign.testForCOR();
        /*-----------Builder Pattern---------------------------*/
        lowLevelDesign.testForBuilderPattern();
        /*-----------Composite Pattern---------------------------*/
        lowLevelDesign.testForCompositePattern();
        lowLevelDesign.testUnixFileSearch();
        /*------------Decorator Pattern------------------------*/
        lowLevelDesign.testForDecoratorPizzaExample();
        log.info("Ended Low Level Design");
    }
}
