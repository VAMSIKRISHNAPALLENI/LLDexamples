package org.practice.example.backoffstrategy.web;

import org.practice.example.backoffstrategy.responses.RepeaterResult;
import org.practice.example.backoffstrategy.service.BackoffStrategy;
import org.practice.example.backoffstrategy.service.Repeater;
import org.practice.example.backoffstrategy.service.RetryCondition;
import org.practice.example.backoffstrategy.service.impl.ExponentialBackoffStrategy;
import org.practice.example.backoffstrategy.service.impl.FixedBackoffStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ClientBackOffStraregy {

    private static final Logger log = LoggerFactory.getLogger(ClientBackOffStraregy.class);
    public void startMe() {

        BackoffStrategy fixedBackoff = new FixedBackoffStrategy(1000); // 1 second wait
        BackoffStrategy exponentialBackoff = new ExponentialBackoffStrategy(1000, 2.0); // 1 second initial wait, doubling each time

        // Define a retry condition that retries on any RuntimeException or if result is null
        RetryCondition<String> retryCondition = (result, exception) -> {
            if (exception != null && exception instanceof RuntimeException) {
                return true;
            }
            return result == null;
        };

        Repeater<String> repeater = new Repeater<>(5, exponentialBackoff, retryCondition);

        try {
            RepeaterResult result = repeater.execute(() -> {
                // Replace with your operation that might fail
                if (Math.random() > 0.8) {
                    throw new RuntimeException("Operation failed");
                }
                return Math.random() > 0.5 ? "Success" : null;
            });
            log.info("Result: {}",result.getResult());
        } catch (Exception e) {
            log.error("Operation failed after retries: {}" ,e.getMessage());
        }

    }
}
