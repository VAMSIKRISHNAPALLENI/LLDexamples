package org.practice;

import org.practice.chainofresponsibility.entity.ProcessRequest;

public class MockData {
    public static ProcessRequest getMockProcessRequest() {
        ProcessRequest processRequest = new ProcessRequest();
        processRequest.setPrecheckNeeded(true);
        processRequest.setValidationCheck(true);
        processRequest.setData("TestCase1");
        processRequest.setMsg("My First Project Success");
        return processRequest;
    }
}
