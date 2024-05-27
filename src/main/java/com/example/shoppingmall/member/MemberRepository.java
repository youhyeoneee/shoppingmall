package com.example.shoppingmall.member;

import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findByUserId(String userId);
    Optional<Member> findByUserIdAndPw(String userId, String pw);


}
