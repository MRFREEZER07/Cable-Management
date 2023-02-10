package com.cablemanagement.cable_management.exception;

public class DeActiveException  extends RuntimeException {

    public DeActiveException(Boolean active) {
            super("the Customer is already inActive");
         
       
    }
}
