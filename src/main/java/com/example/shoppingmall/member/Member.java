package com.example.shoppingmall.member;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Member {
    String userId;
    String pw;
    String name;
    String email;
    String contact;

    public static Member fromDtoToEntity(MemberDTO memberDto) {
        return new Member(memberDto.getUserId(), memberDto.getPw(),
                memberDto.getName(), memberDto.getEmail(), memberDto.getContact());
    }


    @Override
    public String toString() {
        return "Member {" +
                "user_id='" + userId + '\'' +
                "pw='" + pw + '\'' +
                "name='" + name + '\'' +
                "email='" + email + '\'' +
                "contact='" + contact + '\'' +
                "}";
    }
}
