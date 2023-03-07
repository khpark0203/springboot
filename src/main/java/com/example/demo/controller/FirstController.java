package com.example.demo.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.FirstService;

@RestController
public class FirstController {

	@Autowired
	private FirstService firstService;

	@GetMapping("/first")
	public Map<String, String> first() {
		return firstService.getFirst();
	}
}