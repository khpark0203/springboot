package com.example.demo.exception;

import lombok.Getter;

@Getter
public enum ErrorMessage {
	NOT_FOUND(1001, "데이터가 없습니다");

	private int    code;
	private String message;

	private ErrorMessage(int code, String message) {
		this.code    = code;
		this.message = message;
	}
}