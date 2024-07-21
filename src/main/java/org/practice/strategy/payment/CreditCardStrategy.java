package org.practice.strategy.payment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CreditCardStrategy implements PaymentStrategy{
    private static final Logger log = LoggerFactory.getLogger(CreditCardStrategy.class);
    private String name;
    private String cardNumber;
    private String cvv;
    private String dateOfExpiry;
    public CreditCardStrategy(String nm, String ccNum, String cvv, String expiryDate){
        this.name=nm;
        this.cardNumber=ccNum;
        this.cvv=cvv;
        this.dateOfExpiry=expiryDate;
    }
    @Override
    public void pay(int amount) {
        log.info("Recieved payment with {}, for Amount {}",name,amount);
    }
}
