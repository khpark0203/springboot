package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;

import com.example.demo.model.Family;

public interface FamilyRepositoryCustom {
    @EntityGraph(attributePaths = {"lecture"})
    List<Family> searchAll();
}