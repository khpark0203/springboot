package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.controller.dto.ErrorResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<ErrorResponse> NotFoundExceptionHandler(NotFoundException e) {
		ErrorResponse res = new ErrorResponse(e.getCode(), e.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(res);
	}
}