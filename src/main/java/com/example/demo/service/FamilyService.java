package com.example.demo.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FamilyService {

    // @Autowired
    // private FamilyRepository familyRepository;

    public Map<String, String> getFamily() {
        Map<String, String> map = new HashMap<>();
        map.put("hi", "first");


        return map;
    }
}