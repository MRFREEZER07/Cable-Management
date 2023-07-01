package com.cablemanagement.cable_management.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code= HttpStatus.NOT_FOUND, reason="was Not Found")
public class HistoryNotFoundException extends RuntimeException {

    public HistoryNotFoundException(Long id) {
        super("the history id " + id + " does not exist");
    }

}
