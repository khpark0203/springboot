package com.example.demo.repository.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Family;
import com.example.demo.repository.FamilyRepository;

interface FamilyJpaRepository extends JpaRepository<Family, Long> {
}

@Primary
@Repository
public class FamilyRepositoryImpl implements FamilyRepository {

	@Autowired
	private FamilyJpaRepository familyJpaRepository;

	@Override
	public List<Family> list() {
		System.out.println("JPA Repo: " + familyJpaRepository);

		return familyJpaRepository.findAll();
	}

	@Override
	public Family create(Family family) {
		return familyJpaRepository.save(family);
	}

	@Override
	public Optional<Family> getFamily(Long id) {
		return familyJpaRepository.findById(id);
	}
}