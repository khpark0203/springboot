package com.example.demo.controller;

import java.util.ArrayList;
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

import com.example.demo.client.GoarchClient;
import com.example.demo.controller.dto.FamilyRequest;
import com.example.demo.controller.dto.FamilyResponse;
import com.example.demo.model.Family;
import com.example.demo.service.FamilyService;

@RestController
@RequestMapping("/family")
public class FamilyController {

    @Autowired
    // @Qualifier("hiServiceImpl")
    private FamilyService familyService;

    @GetMapping("")
    public ResponseEntity<List<FamilyResponse>> getFamilyList() {
        List<Family> familyList = familyService.getFamilyList();
        List<FamilyResponse> res = new ArrayList<>();

        for (Family f : familyList) {
            FamilyResponse familyRes = new FamilyResponse();
            res.add(familyRes.fromEntity(f));
        }

        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FamilyResponse> getFamily(@PathVariable Long id) {
        Family family = familyService.getFamily(id);
        FamilyResponse familyResponse = new FamilyResponse().fromEntity(family);
        
        return new ResponseEntity<>(familyResponse, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<FamilyResponse> create(@RequestBody FamilyRequest familyReq) {
        FamilyResponse res = new FamilyResponse();
        res.fromEntity(familyService.createFamily(familyReq.toEntity()));
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
}