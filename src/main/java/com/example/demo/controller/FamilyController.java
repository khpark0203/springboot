package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.controller.dto.FamilyDto.FamilyRequest;
import com.example.demo.controller.dto.FamilyDto.FamilyResponse;
import com.example.demo.service.FamilyService;

@RestController
@RequestMapping("/family")
public class FamilyController {

    @Autowired
    // @Qualifier("hiServiceImpl")
    private FamilyService familyService;

    @GetMapping("")
    public ResponseEntity<List<FamilyResponse>> getFamilyList() {
        List<FamilyResponse> familyList = familyService.getFamilyList();

        return new ResponseEntity<>(familyList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FamilyResponse> getFamily(@PathVariable Long id) {
        FamilyResponse family = familyService.getFamily(id);

        return new ResponseEntity<>(family, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<FamilyResponse> create(@RequestBody FamilyRequest familyReq) {
        FamilyResponse res = familyService.createFamily(familyReq);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FamilyResponse> update(
        @PathVariable Long id,
        @RequestBody FamilyRequest familyReq
    ) {
        familyReq.setId(id);
        FamilyResponse res = familyService.updateFamily(familyReq);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
}