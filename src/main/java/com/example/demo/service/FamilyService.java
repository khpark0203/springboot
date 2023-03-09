package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Family;

public interface FamilyService {
    List<Family> getFamily();
    Family createFamily(Family family);
}