package org.practice;

import org.practice.builderpattern.pizza.MakePizza;
import org.practice.chainofresponsibility.chain.*;
import org.practice.chainofresponsibility.entity.ProcessRequest;
import org.practice.composite.TriggerComposite;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class LowLevelDesign {
    private static final Logger log = LoggerFactory.getLogger(LowLevelDesign.class);
    BaseChain baseChain = new BaseChain(new PreCheckProcess(new ValidateProcess(new WriteProcess(new PostWriteProcess(null)))));

    TriggerComposite composite= new TriggerComposite();
    public LowLevelDesign() {
    }

    public void testForCOR() {
        log.info("Starting Chain Of Responsibilty");
        ProcessRequest processRequest = this.getMockProcessRequest();
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
        log.info("Composite Started");
        composite.runFileSystem();
        log.info("Composite Ended");
    }

    public ProcessRequest getMockProcessRequest() {
        ProcessRequest processRequest = new ProcessRequest();
        processRequest.setPrecheckNeeded(true);
        processRequest.setValidationCheck(true);
        processRequest.setData("TestCase1");
        processRequest.setMsg("My First Project Success");
        return processRequest;
    }
}
