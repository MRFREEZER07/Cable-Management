package com.cablemanagement.cable_management.exception;

public class HistoryNotFoundException extends RuntimeException {

    public HistoryNotFoundException(Long id) {
        super("the history id " + id + " does not exist");
    }

}
