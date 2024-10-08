package org.practice;

import org.practice.builderpattern.pizza.MakePizza;
import org.practice.chainofresponsibility.chain.*;
import org.practice.chainofresponsibility.entity.ProcessRequest;
import org.practice.composite.simplefilesystem.TriggerComposite;
import org.practice.composite.unixfilesearch.Directory;
import org.practice.composite.unixfilesearch.File;
import org.practice.composite.unixfilesearch.FileSearcher;
import org.practice.composite.unixfilesearch.SearchParams;
import org.practice.decoratorpattern.pizza_example.Pizza;
import org.practice.decoratorpattern.pizza_example.pizzastyle.FarmHouse;
import org.practice.decoratorpattern.pizza_example.toppings.Cheese;
import org.practice.decoratorpattern.pizza_example.toppings.Chicken;
import org.practice.decoratorpattern.pizza_example.toppings.Toppings;
import org.practice.decoratorpattern.pizza_example.toppings.Veggies;
import org.practice.example.backoffstrategy.web.ClientBackOffStraregy;
import org.practice.strategy.payment.CreditCardStrategy;
import org.practice.strategy.payment.Item;
import org.practice.strategy.payment.PaypalStrategy;
import org.practice.strategy.payment.ShoppingCart;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import static org.practice.MockData.getMockProcessRequest;

@Service
public class LowLevelDesign {
    private static final Logger log = LoggerFactory.getLogger(LowLevelDesign.class);
    BaseChain baseChain = new BaseChain(new PreCheckProcess(new ValidateProcess(new WriteProcess(new PostWriteProcess(null)))));

    TriggerComposite composite= new TriggerComposite();
    public LowLevelDesign() {
    }

    public void testForCOR() {
        log.info("Starting Chain Of Responsibilty");
        ProcessRequest processRequest = getMockProcessRequest();
        this.baseChain.invokeChain(processRequest);
        log.info("Ended Chain Of Responsibilty");
    }

    public void testForBuilderPattern(){
        log.info("BuilderPattern Started");
        MakePizza makePizza = new MakePizza();
        makePizza.buildPizza();
        log.info("BuilderPattern Ended");
    }

    public void testForCompositePattern(){
        //https://medium.com/@ngneha090/beginners-guide-to-composite-design-pattern-java-f9ef644e3425
        log.info("Composite Started");
        composite.runFileSystem();
        log.info("Composite Ended");
    }

    public void testForDecoratorPizzaExample(){
        Pizza pizza = new FarmHouse();
        pizza = new Chicken(new Cheese(pizza));
        log.info("Ordered Pizza is {}, and Prize for it is {}",pizza.getpizzaDisc(),pizza.getPrize());
    }

    public void testUnixFileSearch() {
        SearchParams params = new SearchParams();
        params.setExtension("xml");
        params.setMinSize(2);
        params.setMaxSize(100);

        File xmlFile = new File();
        xmlFile.setContent("aaa.xml".getBytes());
        xmlFile.setName("aaa.xml");

        File txtFile = new File();
        txtFile.setContent("bbb.txt".getBytes());
        txtFile.setName("bbb.txt");

        File jsonFile = new File();
        jsonFile.setContent("ccc.json".getBytes());
        jsonFile.setName( "ccc.json");

        Directory dir1 = new Directory();
        dir1.addEntry(txtFile);
        dir1.addEntry(xmlFile);

        Directory dir0 = new Directory();
        dir0.addEntry(jsonFile);
        dir0.addEntry(dir1);

        FileSearcher searcher = new FileSearcher();
        System.out.println(searcher.search(dir0, params));
    }
    public void testForStrategy(){
        ShoppingCart cart = new ShoppingCart();

        Item item1 = new Item("1234",10);
        Item item2 = new Item("5678",40);

        cart.addItem(item1);
        cart.addItem(item2);

        //pay by paypal
        cart.pay(new PaypalStrategy("test@example.com", "pwd"));

        //pay by credit card
        cart.pay(new CreditCardStrategy("Mock Test", "1234567890123456", "786", "12/15"));
    }


    /*-----
    1.Parking lot -> https://swatijha.hashnode.dev/parking-lot-low-level-design

    ------*/

    /*--------Back Off Stategy-----------*/
    public void beginRetyMechanism(){
        ClientBackOffStraregy clientBackOffStraregy= new ClientBackOffStraregy();
        clientBackOffStraregy.startMe();
    }

}
