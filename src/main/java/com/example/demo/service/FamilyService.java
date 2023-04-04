package com.example.demo.service;

import java.util.List;

import com.example.demo.controller.dto.FamilyDto.FamilyRequest;
import com.example.demo.controller.dto.FamilyDto.FamilyResponse;

public interface FamilyService {
    List<FamilyResponse> getFamilyList();
    List<FamilyResponse> getFamilyListWithLecture();
    FamilyResponse createFamily(FamilyRequest family);
    FamilyResponse updateFamily(FamilyRequest family);
    FamilyResponse getFamily(Long id);
}