package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.controller.dto.ErrorDto.ErrorResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponse> NotFoundExceptionHandler(NotFoundException e) {
        ErrorResponse res = new ErrorResponse(e.getCode(), e.getMessage());
        return new ResponseEntity<ErrorResponse>(res, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InternalServerException.class)
    public ResponseEntity<ErrorResponse> InternalServerExceptionHandler(InternalServerException e) {
        ErrorResponse res = new ErrorResponse(e.getCode(), e.getMessage());
        return new ResponseEntity<ErrorResponse>(res, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}