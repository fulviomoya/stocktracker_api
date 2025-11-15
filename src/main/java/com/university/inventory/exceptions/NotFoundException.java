package com.university.inventory.exceptions;

public class RecursoNoEncontradoException extends Exception {
    private String message;

    public RecursoNoEncontradoException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
