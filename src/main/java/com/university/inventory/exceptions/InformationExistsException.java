package com.university.inventory.exceptions;

public class InformationExistsException extends Throwable {
    private String message;

    public InformationExistsException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
