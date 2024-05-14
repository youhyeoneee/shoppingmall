package com.example.shoppingmall.member;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@AllArgsConstructor
@RestController
public class MemberContoller {
    MemberService memberService;

    @PostMapping("/join")
    public ApiResult<String> join(@RequestBody Member member) throws DuplicateException {
        log.info(member.toString());

        try {
            if (isDuplicateId(member)) {
                throw new DuplicateException("중복된 ID 입니다.");
            }
        } catch (DuplicateException e) {
            return new ApiResult<>(false, null, new ApiResult.ApiError("아이디 중복", HttpStatus.CONFLICT));
        }

        String userId = memberService.join(member);
        return new ApiResult<>(true, userId, null);
    }

    boolean isDuplicateId(Member member) {
        return memberService.checkDuplicateId(member.getUserId());
    }
}
