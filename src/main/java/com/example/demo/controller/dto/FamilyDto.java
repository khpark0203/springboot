package com.example.demo.controller.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FamilyDto {

	@Getter
	@Setter
	public static class FamilyResponse {
		private Long id;
		private String name;
	}

	@Getter
	@Setter
	public static class FamilyRequest {
		private Long id;
		private String name;
	}
}