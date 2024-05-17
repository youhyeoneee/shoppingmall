package com.example.shoppingmall.member;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class MemberDTO {
    @JsonProperty("user_id")
    String userId;
    String pw;
    String name;
    String email;
    String contact;

    public Member convertToEntity() {
        return new Member(userId, pw, name, email, contact);
    }
}

