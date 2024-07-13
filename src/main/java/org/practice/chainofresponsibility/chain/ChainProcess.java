package org.practice.chainofresponsibility.chain;


import org.practice.chainofresponsibility.entity.ProcessRequest;

public abstract class ChainProcess {
    ChainProcess nextChainProcess;

    public ChainProcess(ChainProcess nextChainProcess) {
        this.nextChainProcess = nextChainProcess;
    }

    public void doProcess(ProcessRequest processRequest) {
        if (this.nextChainProcess != null) {
            this.nextChainProcess.doProcess(processRequest);
        }

    }
}
