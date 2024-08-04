package org.practice.example.backoffstrategy.service;

@FunctionalInterface
public interface RetryCondition<T> {
    boolean shouldRetry(T result, Exception e);
}
