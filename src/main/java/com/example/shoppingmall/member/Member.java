package com.example.shoppingmall.member;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Member {
    private int id; // PK
    private String userId;
    private String pw;
    private String name;
    private String email;
    private String contact;

    public Member(String userId, String pw, String name, String email, String contact) {
        this.userId = userId;
        this.pw = pw;
        this.name = name;
        this.email = email;
        this.contact = contact;
    }

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
