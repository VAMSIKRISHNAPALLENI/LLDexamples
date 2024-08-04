package org.practice.example.backoffstrategy.service.impl;

import org.practice.example.backoffstrategy.service.BackoffStrategy;

public class FixedBackoffStrategy implements BackoffStrategy {
    private final long waitDuration;

    public FixedBackoffStrategy(long waitDuration) {
        this.waitDuration = waitDuration;
    }

    @Override
    public long getWaitDuration(int attempt) {
        return waitDuration;
    }
}

