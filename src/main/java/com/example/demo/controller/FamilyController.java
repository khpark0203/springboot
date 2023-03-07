package com.example.demo.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.FamilyService;

@RestController
public class FamilyController {

	@Autowired
	private FamilyService familyService;

	@GetMapping("/family")
	public Map<String, String> family() {
		return familyService.getFamily();
	}
}