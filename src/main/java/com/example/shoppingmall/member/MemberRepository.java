package com.example.shoppingmall.member;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MemberRepository {

    @Autowired
    @PersistenceContext
    EntityManager entityManager;

    Map<String, Member> memberTable = new HashMap<>();


    public void save(Member member) {
        entityManager.persist(member);
    }

    public Member findByUserId(String userId) {
        String jpql = "SELECT m FROM Member AS m WHERE m.userId = :userId";

        return entityManager.createQuery(jpql, Member.class)
                .setParameter("userId", userId)
                .getSingleResult();
    }

    public Member findById(int id) {
        return entityManager.find(Member.class, id);
    }

    public List<Member> findsByUserIdPw(@Param("userId") String userId, @Param("password") String password) {
        List<Member> resultList = entityManager.createQuery("select m from Member as m where m.userId = :userId and m.pw = :password", Member.class).setParameter("userId", userId).setParameter("password", password).getResultList();
        return resultList;
    }

}
