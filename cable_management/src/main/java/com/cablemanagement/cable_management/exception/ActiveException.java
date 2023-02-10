package com.cablemanagement.cable_management.exception;

public class ActiveException extends RuntimeException {

    public ActiveException(Boolean active) {
            super("the Customer is already active");
         
       
    }
    
}
