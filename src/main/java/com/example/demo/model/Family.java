package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Family {

	@Id
	@GeneratedValue
	private int id;

	private String name;

	public String getName() {
		return name;
	}
}