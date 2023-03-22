package com.example.demo.controller.dto;

import lombok.Getter;
import lombok.Setter;

public class ErrorDto {
    @Getter
    @Setter
    public static class ErrorResponse {
    
        private String message;
        private int    code;
    
        public ErrorResponse(int code) {
            this.code    = code;
        }
    
        public ErrorResponse(String message) {
            this.message = message;
        }
    
        public ErrorResponse(int code, String message) {
            this.code    = code;
            this.message = message;
        }
    }
}
