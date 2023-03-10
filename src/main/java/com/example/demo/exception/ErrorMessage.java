package com.example.demo.exception;

import lombok.Getter;

@Getter
public enum ErrorMessage {
	NOT_FOUND("찾을 수 없습니다");

	private String message;
	private ErrorMessage(String message) {
		this.message = message;
	}
}