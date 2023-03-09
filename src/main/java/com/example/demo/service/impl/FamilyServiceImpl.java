package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.demo.model.Family;
import com.example.demo.repository.FamilyRepository;
import com.example.demo.service.FamilyService;

@Service
@Primary
public class FamilyServiceImpl implements FamilyService {

    @Autowired
    private FamilyRepository familyRepository;

	@Override
	public List<Family> getFamily() {
		return familyRepository.list();
	}

	@Override
	public Family createFamily(Family family) {
		return familyRepository.create(family);
	}
}