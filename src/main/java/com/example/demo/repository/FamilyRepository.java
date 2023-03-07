package com.example.demo.repository;

import org.springframework.stereotype.Repository;
import com.example.demo.model.Family;


@Repository
public class FamilyRepository {

	private Family family;

	public Family getName(int id) {
		return family; 
	}
}