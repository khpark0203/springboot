package com.example.demo.exception;

import lombok.Getter;

@Getter
public enum ErrorMessage {
    ERROR_MESSAGE_START(100000, "에러메시지 enum 시작"),

    NOT_FOUND(404001, "데이터가 없습니다"),
    
    INTERNAL_ERROR(500001, "서버 내부 오류"),
    CLIENT_INTERNAL_ERROR(500500, "호출 서버 오류"),
    


    ERROR_MESSAGE_END(999999, "에러메시지 enum 마지막")
    ;

    private int    code;
    private String message;

    private ErrorMessage(int code, String message) {
        this.code    = code;
        this.message = message;
    }
}