package com.example.demo.client.message;

import lombok.Getter;

public class GoarchClientMessage {

    @Getter
    public static class GoarchUserResponse {
        private int id;
        private String name;
        private int age;
        private String createdAt;
        private String updatedAt;
        private String deletedAt;
    }

    @Getter
    public static class GoarchUserRequest {
        private String name;
        private int age;
    }
}