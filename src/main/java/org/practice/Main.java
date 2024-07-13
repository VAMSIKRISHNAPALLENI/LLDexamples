package org.practice;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(
        scanBasePackages = {"org.practice"}
)
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        LowLevelDesign lowLevelDesign = new LowLevelDesign();
        lowLevelDesign.testForCOR();
    }
}
