package com.example.demo.controller.dto;

import com.example.demo.model.Family;
import com.example.demo.model.Lecture;

import lombok.Getter;
import lombok.Setter;

public class FamilyDto {

    @Getter
    @Setter
    public static class FamilyRequest {
        private Long id;
        private String name;
        private Lecture lecture;
    
        public Family toEntity() {
            return Family.builder()
                        .id(id)
                        .name(name)
                        .lecture(lecture)
                        .build();
        }
    }

    @Getter
    public static class FamilyResponse {
        private Long id;
        private String name;
        private Lecture lecture;

        public FamilyResponse fromEntity(Family f) {
            this.id      = f.getId();
            this.name    = f.getName();
            this.lecture = f.getLecture();

            return this;
        }
    }
}
