package com.example.demo.controller.dto;

import com.example.demo.model.Family;

import lombok.Getter;

public class FamilyDto {

    @Getter
    public static class FamilyRequest {
        private Long id;
        private String name;
    
        public Family toEntity() {
            return Family.builder()
                        .id(this.id)
                        .name(this.name)
                        .build();
        }
    }

    @Getter
    public static class FamilyResponse {
        private Long id;
        private String name;

        public FamilyResponse fromEntity(Family f) {
            FamilyResponse fr = new FamilyResponse();
            fr.id   = f.getId();
            fr.name = f.getName();
            return fr;
        }
    }
}
