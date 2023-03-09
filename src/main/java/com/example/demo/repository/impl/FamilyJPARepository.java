package com.example.demo.repository.impl;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Family;

public interface FamilyJPARepository extends JpaRepository<Family, Long> {
}