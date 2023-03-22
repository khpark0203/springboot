package com.example.demo.client.message;

import lombok.Getter;
import lombok.Setter;

public class GoarchClientMessage {

    @Getter
    @Setter
    public static class GoarchUserResponse {
        private int id;
        private String name;
        private int age;
        private String createdAt;
        private String updatedAt;
        private String deletedAt;
    }
}