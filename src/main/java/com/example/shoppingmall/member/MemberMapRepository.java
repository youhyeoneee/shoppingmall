package com.example.shoppingmall.member;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class MemberMapRepository implements MemberRepository {

    @Autowired
    @PersistenceContext
    EntityManager entityManager;


    @Override
    public Member save(Member member) {
        entityManager.persist(member);
        return member;
    }

    public Optional<Member> findByUserId(String userId) {
        String jpql = "SELECT m FROM Member AS m WHERE m.userId = :userId";

        Member foundMember = entityManager.createQuery(jpql, Member.class)
                .setParameter("userId", userId)
                .getSingleResult();;

        if (foundMember == null)
            return null;
        else {
            return Optional.of(foundMember);
        }
    }

    public Optional<Member> findByUserIdAndPw(String userId, String password) {
        Member foundMember = entityManager.createQuery("select m from Member as m where m.userId = :userId and m.pw = :password", Member.class).setParameter("userId", userId).setParameter("password", password).getSingleResult();

        if (foundMember == null)
            return null;
        else {
            return Optional.of(foundMember);
        }
    }
}