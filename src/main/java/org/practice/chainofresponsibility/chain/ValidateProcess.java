package org.practice.chainofresponsibility.chain;

import org.practice.chainofresponsibility.entity.ProcessRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class ValidateProcess extends ChainProcess {
    private static final Logger log = LoggerFactory.getLogger(ValidateProcess.class);

    public ValidateProcess(WriteProcess writeProcess) {
        super(writeProcess);
    }

    public void doProcess(ProcessRequest processRequest) {
        log.info("Chain in Validate Process");
        this.checkValidation(processRequest);
        super.doProcess(processRequest);
    }

    private void checkValidation(ProcessRequest processRequest) {
        if (!processRequest.isValidationCheck()) {
            log.error("Validation failed");
            return;
        } else {
            log.info("Validation Success");
        }
    }
}