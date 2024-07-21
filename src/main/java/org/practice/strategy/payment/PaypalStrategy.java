package org.practice.strategy.payment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PaypalStrategy implements PaymentStrategy{
    private static final Logger log = LoggerFactory.getLogger(PaypalStrategy.class);
    private String emailId;
    private String password;

    public PaypalStrategy(String email, String pwd){
        this.emailId=email;
        this.password=pwd;
    }

    @Override
    public void pay(int amount) {
        log.info("Recieved payment with {}, for Amount {}",emailId,amount);
    }
}
