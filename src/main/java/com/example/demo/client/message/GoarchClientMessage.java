package com.example.demo.client.message;

import lombok.Builder;
import lombok.Getter;

public class GoarchClientMessage {

    @Getter
    public static class GoarchGetUserResponse {
        private int id;
        private String name;
        private int age;
        private String createdAt;
        private String updatedAt;
        private String deletedAt;
    }

    @Getter
    @Builder
    public static class GoarchCreateUserRequest {
        private String name;
        private int age;
    }
}