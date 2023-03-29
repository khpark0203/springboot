package com.example.demo.controller.dto;

import com.example.demo.model.Family;

import lombok.Getter;
import lombok.Setter;

public class FamilyDto {

    @Getter
    @Setter
    public static class FamilyRequest {
        private Long id;
        private String name;
    
        public Family toEntity() {
            return Family.builder()
                        .id(id)
                        .name(name)
                        .build();
        }
    }

    @Getter
    public static class FamilyResponse {
        private Long id;
        private String name;

        public void setFromEntity(Family f) {
            this.id   = f.getId();
            this.name = f.getName();
        }
    }
}
