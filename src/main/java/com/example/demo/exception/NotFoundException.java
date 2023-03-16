package com.example.demo.exception;

public class NotFoundException extends RuntimeException {

    ErrorMessage e;

    public NotFoundException(ErrorMessage err) {
        this.e = err;
    }

    public int getCode() {
        return this.e.getCode();
    }

    public String getMessage() {
        return this.e.getMessage();
    }
}