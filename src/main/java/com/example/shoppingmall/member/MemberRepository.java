package com.example.shoppingmall.member;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class MemberRepository {

    @Autowired
    @PersistenceContext
    EntityManager entityManager;

    Map<String, Member> memberTable = new HashMap<>();


    public Member save(Member member) {
        entityManager.persist(member);
        Member savedMember = entityManager.find(Member.class, member.getId());
        return savedMember;
    }

    public Member findById(String userId) {
        return memberTable.get(userId);
    }
}
