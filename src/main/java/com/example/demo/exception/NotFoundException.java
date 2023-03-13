package com.example.demo.exception;

public class NotFoundException extends RuntimeException {

	ErrorMessage e;

	public NotFoundException(ErrorMessage err) {
		this.e = err;
	}

	public int getCode() {
		return e.getCode();
	}

	public String getMessage() {
		return e.getMessage();
	}
}