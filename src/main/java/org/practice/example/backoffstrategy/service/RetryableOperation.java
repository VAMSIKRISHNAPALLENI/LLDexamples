package org.practice.example.backoffstrategy.service;

@FunctionalInterface
public interface RetryableOperation<T> {
    T execute() throws Exception;
}

