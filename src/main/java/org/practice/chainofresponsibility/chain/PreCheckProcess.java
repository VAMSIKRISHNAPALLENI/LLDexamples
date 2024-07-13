package org.practice.chainofresponsibility.chain;

import org.practice.chainofresponsibility.entity.ProcessRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class PreCheckProcess extends ChainProcess {
    private static final Logger log = LoggerFactory.getLogger(PreCheckProcess.class);

    public PreCheckProcess(ValidateProcess validateProcess) {
        super(validateProcess);
    }

    public void doProcess(ProcessRequest processRequest) {
        log.info("Chain in Pre-Check Process");
        this.checkForPreCheckProcessEnabled(processRequest);
        super.doProcess(processRequest);
    }

    private void checkForPreCheckProcessEnabled(ProcessRequest processRequest) {
        if (!processRequest.isPrecheckNeeded()) {
            log.error("Pre-check Disabled");
        } else {
            log.info("Pre-check Success");
        }
    }
}
