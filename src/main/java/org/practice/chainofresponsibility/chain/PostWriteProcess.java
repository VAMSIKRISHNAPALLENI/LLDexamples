package org.practice.chainofresponsibility.chain;

import lombok.extern.slf4j.Slf4j;
import org.practice.chainofresponsibility.entity.ProcessRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class PostWriteProcess extends ChainProcess {
    private static final Logger log = LoggerFactory.getLogger(PostWriteProcess.class);

    public PostWriteProcess(ChainProcess chainProcess) {
        super(chainProcess);
    }

    public void doProcess(ProcessRequest processRequest) {
        log.info("Chain in Post Write Process");
        this.triggerNotification(processRequest);
        super.doProcess(processRequest);
    }

    public void triggerNotification(ProcessRequest processRequest) {
        log.info("Notification Triggered");
        log.info("{}", processRequest.getMsg());
    }
}

