package com.example.shoppingmall.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Repository
public class MemberRepository {

    @Autowired
    DataSource dataSource;
    Map<String, Member> memberTable = new HashMap<>();

    public void makeConnection() {
        DataSourceUtils.getConnection(dataSource);
    }

    public String save(Member member) {
        memberTable.put(member.getUserId(), member);

        return member.getUserId();
    }

    public Member findById(String userId) {
        return memberTable.get(userId);
    }
}
