package com.example.shoppingmall.member;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Member {
    int id;
    @JsonProperty("user_id")
    String userId;
    String pw;
    String name;
    String email;
    String contact;

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
