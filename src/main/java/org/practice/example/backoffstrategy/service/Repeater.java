package org.practice.example.backoffstrategy.service;

import org.practice.example.backoffstrategy.responses.RepeaterResult;
import org.practice.example.backoffstrategy.service.BackoffStrategy;
import org.practice.example.backoffstrategy.service.RetryCondition;
import org.practice.example.backoffstrategy.service.RetryableOperation;

public class Repeater<T> {
    private final int maxRetries;
    private final BackoffStrategy backoffStrategy;
    private final RetryCondition<T> retryCondition;


    // Operation is a lambda you will send while invoking this function
    public Repeater(int maxRetries, BackoffStrategy backoffStrategy, RetryCondition<T> retryCondition) {
        this.maxRetries = maxRetries;
        this.backoffStrategy = backoffStrategy;
        this.retryCondition = retryCondition;
    }

    public RepeaterResult<T> execute(RetryableOperation<T> operation) {
        int attempt = 0;
        while (true) {
            try {
                T result = operation.execute();
                if (!retryCondition.shouldRetry(result, null)) {
                    return new RepeaterResult<>(true, result, null);
                } else if (++attempt > maxRetries) {
                    return new RepeaterResult<>(false, result, null);
                }
            } catch (Exception e) {
                if (++attempt > maxRetries || !retryCondition.shouldRetry(null, e)) {
                    return new RepeaterResult<>(false, null, e);
                }
            }
            try {
                Thread.sleep(backoffStrategy.getWaitDuration(attempt));
            } catch (InterruptedException ie) {
                Thread.currentThread().interrupt();
                return new RepeaterResult<>(false, null, ie);
            }
        }
    }
}
