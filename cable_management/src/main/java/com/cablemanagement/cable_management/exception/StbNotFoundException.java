package com.cablemanagement.cable_management.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code= HttpStatus.NOT_FOUND, reason="was Not Found")
public class StbNotFoundException extends RuntimeException {

    public StbNotFoundException(Long id) {
        super("the Stb id " + id + " does not exist");
    }
}
