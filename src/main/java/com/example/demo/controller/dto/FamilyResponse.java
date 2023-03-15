package com.example.demo.controller.dto;

import com.example.demo.model.Family;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FamilyResponse {
	private Long id;
	private String name;

	public FamilyResponse fromEntity(Family f) {
		this.id = f.getId();
		this.name = f.getName();
		return this;
	}
}
