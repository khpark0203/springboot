package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.controller.dto.FamilyDto.FamilyResponse;
import com.example.demo.model.Family;
import com.example.demo.service.FamilyService;

@RestController
@RequestMapping("/family")
public class FamilyController {

    @Autowired
    // @Qualifier("hiServiceImpl")
    private FamilyService familyService;

    @GetMapping("")
    public List<Family> getFamilyList() {
        return familyService.getFamilyList();
    }

    @GetMapping("/asdf")
    public List<Family> fff() {
        return familyService.getFFF();
    }

    @GetMapping("/{id}")
    public ResponseEntity<FamilyResponse> getFamily(@PathVariable Long id) {
        Family family = familyService.getFamily(id);
        FamilyResponse familyResponse = new FamilyResponse();
        ResponseEntity<FamilyResponse> res = new ResponseEntity<>(familyResponse, HttpStatus.OK);

        familyResponse.setId(family.getId());
        familyResponse.setName(family.getName());
        
        return res;
    }

    @PostMapping("")
    public Family create(@RequestBody Family family) {
        return familyService.createFamily(family);
    }
}