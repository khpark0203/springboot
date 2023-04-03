package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.demo.client.GoarchClient;
import com.example.demo.controller.dto.FamilyDto.FamilyRequest;
import com.example.demo.controller.dto.FamilyDto.FamilyResponse;
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
    public List<FamilyResponse> getFamilyList() {
        // TODO: 지우기 그냥 테스트용
        // List<GoarchGetUserResponse> l = goarchClient.getUsers();
        // log.info("{}", l);

        // GoarchCreateUserRequest user = GoarchCreateUserRequest.builder()
        //                                                     .name("kwanho")
        //                                                     .age(99)
        //                                                     .build();
        // goarchClient.createUser(user);

        List<Family> familyList = familyRepository.searchAll();
        List<FamilyResponse> familyRes = new ArrayList<>();

        for (Family f : familyList) {
            FamilyResponse fr = new FamilyResponse().setFromEntity(f);
            familyRes.add(fr);
        }

        return familyRes;
    }

    @Override
    public FamilyResponse createFamily(FamilyRequest family) {
        Family familyEntity = family.toEntity();
        familyRepository.save(familyEntity);
        FamilyResponse familyRes = new FamilyResponse().setFromEntity(familyEntity);

        return familyRes;
    }

    @Override
    public FamilyResponse updateFamily(FamilyRequest family) {
        Family familyEntity = family.toEntity();
        familyRepository.save(familyEntity);
        FamilyResponse familyRes = new FamilyResponse().setFromEntity(familyEntity);
        return familyRes;
    }

    @Override
    public FamilyResponse getFamily(Long id) {
        Family f = familyRepository.findById(id).orElseThrow(() -> new NotFoundException(ErrorMessage.NOT_FOUND));

        return new FamilyResponse().setFromEntity(f);
    }
}