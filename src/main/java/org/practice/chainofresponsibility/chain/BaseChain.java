package org.practice.chainofresponsibility.chain;

import org.practice.chainofresponsibility.entity.ProcessRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class BaseChain {
    private static final Logger log = LoggerFactory.getLogger(BaseChain.class);
    ChainProcess chainProcess;

    public BaseChain(PreCheckProcess preCheckProcess) {
        this.chainProcess = preCheckProcess;
    }

    public void invokeChain(ProcessRequest processRequest) {
        log.info("Invoking the COR");
        this.chainProcess.doProcess(processRequest);
    }
}
