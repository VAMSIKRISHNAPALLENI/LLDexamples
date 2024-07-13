package org.practice.chainofresponsibility.entity;

import lombok.Data;

@Data
public class ProcessRequest {
    boolean isValidationCheck;
    boolean isPrecheckNeeded;
    String data;
    String msg;

}
