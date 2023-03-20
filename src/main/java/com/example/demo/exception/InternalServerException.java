package com.example.demo.exception;

public class InternalServerException extends RuntimeException {

    ErrorMessage e;

    public InternalServerException(ErrorMessage err) {
        this.e = err;
    }

    public int getCode() {
        return this.e.getCode();
    }

    public String getMessage() {
        return this.e.getMessage();
    }
}