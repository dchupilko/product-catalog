package com.dchupilko.product.exception;

public class ProductModelNotFoundException extends RuntimeException {

    public ProductModelNotFoundException(String id) {
        super("Warehouse with id=" + id + " is not found");
    }
}
