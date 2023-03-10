package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Family;
import com.example.demo.service.FamilyService;

@RestController
@RequestMapping("/family")
public class FamilyController {

	@Autowired
	// @Qualifier("hiServiceImpl")
	private FamilyService familyService;

	@GetMapping("")
	public List<Family> getFamilyList() {
		return familyService.getFamilyList();
	}

	@GetMapping("/{id}")
	public ResponseEntity<FamilyResponse> getFamily(@PathVariable Long id) {
		return familyService.getFamily(id);
	}

	@PostMapping("")
	public Family create(@RequestBody Family family) {
		return familyService.createFamily(family);
	}
}