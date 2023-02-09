package com.cablemanagement.cable_management.exception;

public class CustomerNotFoundException extends RuntimeException {

    public CustomerNotFoundException(Long id) {
        super("the customer id " + id + " does not exist");
    }
}
