package com.cablemanagement.cable_management.exception;

public class PaymentNotFoundException extends RuntimeException {

    public PaymentNotFoundException(Long id) {
        super("the payment id " + id + " does not exist");
    }
}
