package com.example.demo.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class FirstService {
    public Map<String, String> getFirst() {
        Map<String, String> map = new HashMap<>();
        map.put("hi", "first");


        return map;
    }
}