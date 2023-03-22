package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.demo.client.GoarchClient;
import com.example.demo.client.message.GoarchClientMessage.GoarchUserResponse;
import com.example.demo.exception.ErrorMessage;
import com.example.demo.exception.NotFoundException;
import com.example.demo.model.Family;
import com.example.demo.repository.FamilyRepository;
import com.example.demo.service.FamilyService;

import lombok.extern.slf4j.Slf4j;

@Service
@Primary
@Slf4j
public class FamilyServiceImpl implements FamilyService {

    @Autowired
    private FamilyRepository familyRepository;

    @Autowired
    private GoarchClient goarchClient;

    @Override
    public List<Family> getFamilyList() {
        // TODO: 지우기 그냥 테스트용
        List<GoarchUserResponse> l = goarchClient.getUsers();
        log.info("info log = {}", l);

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