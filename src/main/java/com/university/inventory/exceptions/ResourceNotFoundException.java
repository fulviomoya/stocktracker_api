package com.university.inventory.exceptions;

public class ResourceNotFoundException extends Exception {
    private String supplierNotFound;

    public ResourceNotFoundException(String supplierNotFound) {
        this.supplierNotFound = supplierNotFound;
    }

    @Override
    public String getMessage() {
        return supplierNotFound;
    }

    @Override
    public String toString() {
        return "ResourceNotFoundException{" +
                "supplierNotFound='" + supplierNotFound + '\'' +
                '}';
    }
}
