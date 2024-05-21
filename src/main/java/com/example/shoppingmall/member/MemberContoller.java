package com.example.shoppingmall.member;

import com.example.shoppingmall.utils.ApiUtils;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

import static com.example.shoppingmall.utils.ApiUtils.error;
import static com.example.shoppingmall.utils.ApiUtils.success;

@Slf4j
@AllArgsConstructor
@RestController
public class MemberContoller {
    MemberService memberService;

    @PostMapping("/join")
    public ApiUtils.ApiResult join(@Valid @RequestBody MemberDTO memberDto) {
        if (isDuplicateId(memberDto)) {
            return error("아이디 중복", HttpStatus.CONFLICT);
        }

        Member requestMember = memberDto.convertToEntity();
        Member savedMember = memberService.join(requestMember);
        return success(savedMember);
    }

    boolean isDuplicateId(MemberDTO memberDto) {
        return memberService.checkDuplicateId(memberDto.getUserId());
    }
}
