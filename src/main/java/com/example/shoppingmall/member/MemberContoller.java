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
    public ApiUtils.ApiResult<String> join(@Valid @RequestBody MemberDTO memberDto) {
        String result = memberService.join(memberDto);
        return success(result);
    }

    @PostMapping("/check-id")
    public ApiUtils.ApiResult<String> checkUsableId(@RequestBody String userId) {
        if (isDuplicateId(userId))
            throw new DuplicateMemberIdException("이미 존재하는 아이디입니다.");
        return success("사용 가능한 아이디입니다.");
    }

    boolean isDuplicateId(String userId) {
        log.info(userId);
        return memberService.checkDuplicateId(userId);
    }

    @PostMapping("/login")
    public ApiUtils.ApiResult login(@RequestBody Map<String, String> requestBody) {
        String userId = requestBody.get("user_id");
        String password = requestBody.get("pw");

        String loginUser = memberService.login(userId, password);
        if (loginUser == null) {
            return error("로그인 실패", HttpStatus.BAD_REQUEST);
        }

        return success(loginUser + "님 어서오세요");
    }
}
