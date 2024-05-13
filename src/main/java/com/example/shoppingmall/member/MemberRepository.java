package com.example.shoppingmall.member;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class MemberRepository {
    Map<String, Member> memberTable = new HashMap<>();

    public String save(Member member) {
        memberTable.put(member.getUserId(), member);

        return member.getUserId();
    }
}
