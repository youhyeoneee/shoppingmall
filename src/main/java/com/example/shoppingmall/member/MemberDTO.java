package com.example.shoppingmall.member;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;


@Getter
@Setter
public class MemberDTO {
    @JsonProperty("user_id")
    @NotBlank(message = "아이디를 입력해주세요.")
    private String userId;

    @Pattern(regexp = "\t^.*(?=^.{8,15}$)(?=.*\\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$", message = "숫자, 문자, 특수문자 포함 8~15자리 이내여야 합니다.")
    private String pw;

    @NotBlank(message = "이름을 입력해주세요.")
    private String name;

    @NotBlank(message = "이메일을 입력해주세요.")
    @Email(message = "이메일 형식에 맞지 않습니다.")
    private String email;

    @Pattern(regexp = "^01(?:0|1|[6-9])[.-]?(\\d{3}|\\d{4})[.-]?(\\d{4})$", message = "전화번호 형식에 맞지 않습니다.")
    private String contact;

    public Member convertToEntity() {
        return new Member(userId, pw, name, email, contact);
    }
}

