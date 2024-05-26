package com.example.shoppingmall.member;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MemberRepository extends CrudRepository<Member, Integer> {

    Optional<Member> findByUserId(String userId);

    Optional<Member> findByUserIdAndPw(String userId, String pw);

}
