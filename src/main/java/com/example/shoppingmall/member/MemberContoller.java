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
    public ResponseEntity<String> join(@RequestBody Member member) throws DuplicateException {
        log.info(member.toString());

        // ID 중복 체크
        // 중복이면, 사용자 예외 클래스 소환
        //        1) 예외 클래스한테 니가 return해!
        //        2) 예외만 발생 시키고 .. 메세지는 내가 보낼게
        try {
            if (isDuplicateId(member)) {
                throw new DuplicateException("중복된 ID 입니다.");
            }
        } catch (DuplicateException e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
        }

        String userId = memberService.join(member);
        return new ResponseEntity<String>(userId, HttpStatus.OK);
    }

    boolean isDuplicateId(Member member) {
        return memberService.checkDuplicateId(member.getUserId());
    }
}
