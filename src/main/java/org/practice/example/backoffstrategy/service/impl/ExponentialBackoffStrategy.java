package org.practice.example.backoffstrategy.service.impl;

import org.practice.example.backoffstrategy.service.BackoffStrategy;

public class ExponentialBackoffStrategy implements BackoffStrategy {
    private final long initialWaitDuration;
    private final double multiplier;

    public ExponentialBackoffStrategy(long initialWaitDuration, double multiplier) {
        this.initialWaitDuration = initialWaitDuration;
        this.multiplier = multiplier;
    }

    @Override
    public long getWaitDuration(int attempt) {
        return (long) (initialWaitDuration * Math.pow(multiplier, attempt - 1));
    }
}

