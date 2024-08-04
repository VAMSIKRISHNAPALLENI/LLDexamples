package org.practice.example.backoffstrategy.service;

public interface BackoffStrategy {
    long getWaitDuration(int attempt);

}
