package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.Family;

public interface FamilyRepository {

	List<Family> list();
	
	// CRUD
	Family create(Family family);
	Optional<Family> getFamily(Long id);
	// Family update(int id, Family family);
	// Family delete(int id);
}