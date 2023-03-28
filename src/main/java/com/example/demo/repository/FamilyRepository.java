package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Family;

public interface FamilyRepository extends JpaRepository<Family, Long>, FamilyRepositoryCustom {
    @Query("SELECT f FROM Family f")
    List<Family> findFamilyList();
}