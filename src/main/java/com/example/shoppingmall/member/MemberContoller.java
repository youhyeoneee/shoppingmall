package com.example.shoppingmall.member;

import com.example.shoppingmall.utils.ApiUtils;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
        String result = memberService.join(requestMember);
        return success(result);
    }

    boolean isDuplicateId(MemberDTO memberDto) {
        return memberService.checkDuplicateId(memberDto.getUserId());
    }

    @PostMapping("/login")
    public ApiUtils.ApiResult login(@RequestBody Map<String, String> requestBody) {
        String userId = requestBody.get("user_id");
        String password = requestBody.get("pw");

        Member loginUser = memberService.login(userId, password);
        if (loginUser == null) {
            return error("로그인 실패", HttpStatus.BAD_REQUEST);
        }

        return success(loginUser.getUserId() + "님 어서오세요");
    }
}
