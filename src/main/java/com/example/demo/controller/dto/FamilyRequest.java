package com.example.demo.controller.dto;

import com.example.demo.model.Family;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FamilyRequest {
    private Long id;
    private String name;

    public Family toEntity() {
        Family family = new Family();
        family.setId(this.id);
        family.setName(this.name);
        return family;
    }
}