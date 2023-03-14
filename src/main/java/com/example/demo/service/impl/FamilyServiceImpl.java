package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.demo.exception.ErrorMessage;
import com.example.demo.exception.NotFoundException;
import com.example.demo.model.Family;
import com.example.demo.repository.FamilyRepository;
import com.example.demo.service.FamilyService;

@Service
@Primary
public class FamilyServiceImpl implements FamilyService {

    @Autowired
    private FamilyRepository familyRepository;

	@Override
	public List<Family> getFamilyList() {
		return familyRepository.findAll();
	}

	@Override
	public Family createFamily(Family family) {
		return familyRepository.save(family);
	}

	@Override
	public Family getFamily(Long id) {
		return familyRepository.findById(id).orElseThrow(() -> new NotFoundException(ErrorMessage.NOT_FOUND));
	}
}