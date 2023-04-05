package com.example.demo.repository.impl;

import java.util.List;

import com.example.demo.model.Family;
import com.example.demo.model.QFamily;
import com.example.demo.repository.FamilyRepositoryCustom;
import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class FamilyRepositoryImpl implements FamilyRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<Family> searchAll() {
        QFamily f = QFamily.family;
        List<Family> res = jpaQueryFactory.selectFrom(f).fetch();
        return res;
    }
}