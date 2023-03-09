package com.example.demo.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Family;
import com.example.demo.repository.FamilyRepository;

interface FamilyJPARepository extends JpaRepository<Family, Long> {
}

@Primary
@Repository
public class FamilyRepositoryImpl implements FamilyRepository {

	@Autowired
	private FamilyJPARepository familyJPARepository;

	@Override
	public List<Family> list() {
		System.out.println("JPA Repo: " + familyJPARepository);

		return familyJPARepository.findAll();
	}

	@Override
	public Family create(Family family) {
		return familyJPARepository.save(family);
	}

	// @Override
	// public Family get(Long id) {
	// 	return familyJPARepository.findOne(id);
	// }
}