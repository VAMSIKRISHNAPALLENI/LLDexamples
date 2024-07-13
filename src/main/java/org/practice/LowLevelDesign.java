package org.practice;

import org.practice.chainofresponsibility.chain.*;
import org.practice.chainofresponsibility.entity.ProcessRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class LowLevelDesign {
    private static final Logger log = LoggerFactory.getLogger(LowLevelDesign.class);
    BaseChain baseChain = new BaseChain(new PreCheckProcess(new ValidateProcess(new WriteProcess(new PostWriteProcess(null)))));

    public LowLevelDesign() {
    }

    public void testForCOR() {
        log.info("Starting Chain Of Responsibilty");
        ProcessRequest processRequest = this.getMockProcessRequest();
        this.baseChain.invokeChain(processRequest);
        log.info("Ended Chain Of Responsibilty");
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
