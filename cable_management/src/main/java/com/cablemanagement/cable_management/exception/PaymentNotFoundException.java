package com.cablemanagement.cable_management.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code= HttpStatus.NOT_FOUND, reason="was Not Found")
public class PaymentNotFoundException extends RuntimeException {

    public PaymentNotFoundException(Long id) {
        super("the payment id " + id + " does not exist");
    }
}
