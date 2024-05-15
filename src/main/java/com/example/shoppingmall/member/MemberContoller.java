package com.example.shoppingmall.member;

import com.example.shoppingmall.utils.ApiUtils;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import static com.example.shoppingmall.utils.ApiUtils.error;
import static com.example.shoppingmall.utils.ApiUtils.success;

@Slf4j
@AllArgsConstructor
@RestController
public class MemberContoller {
    MemberService memberService;

    @PostMapping("/join")
    public ApiUtils.ApiResult<String> join(@RequestBody Member member) throws DuplicateException {
        log.info(member.toString());

        try {
            if (isDuplicateId(member)) {
                throw new DuplicateException("중복된 ID 입니다.");
            }
        } catch (DuplicateException e) {
            return error("아이디 중복", HttpStatus.CONFLICT);
        }

        String userId = memberService.join(member);
        return success(userId);
    }

    boolean isDuplicateId(Member member) {
        return memberService.checkDuplicateId(member.getUserId());
    }
}
