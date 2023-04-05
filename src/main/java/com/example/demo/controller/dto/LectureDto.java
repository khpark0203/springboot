package com.example.demo.controller.dto;

import com.example.demo.model.Lecture;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class LectureDto {

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class LectureResponse {
        private String name;
        private Integer numberOfPlayer;

        public LectureResponse fromEntity(Lecture l) {
            this.name = l.getName();
            this.numberOfPlayer = l.getNumberOfPlayer();

            return this;
        }
    }
}