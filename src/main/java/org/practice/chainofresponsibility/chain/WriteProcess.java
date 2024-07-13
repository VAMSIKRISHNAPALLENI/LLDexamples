package org.practice.chainofresponsibility.chain;

import org.practice.chainofresponsibility.entity.ProcessRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class WriteProcess extends ChainProcess {
    private static final Logger log = LoggerFactory.getLogger(WriteProcess.class);

    public WriteProcess(PostWriteProcess postWriteProcess) {
        super(postWriteProcess);
    }

    public void doProcess(ProcessRequest processRequest) {
        log.info("Chain in Write Process");
        this.writeIntoDB(processRequest);
        super.doProcess(processRequest);
    }

    private void writeIntoDB(ProcessRequest processRequest) {
        log.info("Writing to DB");
        if (processRequest.getData() != null) {
            log.info("Written Successfully into DB");
        } else {
            log.error("Failed to Write into DB");
            return;
        }
    }
}
