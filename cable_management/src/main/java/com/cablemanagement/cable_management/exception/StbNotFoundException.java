package com.cablemanagement.cable_management.exception;

public class StbNotFoundException extends RuntimeException {

    public StbNotFoundException(Long id) {
        super("the Stb id " + id + " does not exist");
    }
}
