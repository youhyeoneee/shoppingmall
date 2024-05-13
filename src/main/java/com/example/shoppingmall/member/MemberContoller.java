package com.example.shoppingmall.member;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@AllArgsConstructor
@RestController
public class MemberContoller {
    MemberService memberService;

    @PostMapping("/join")
    public ResponseEntity<String> join(@RequestBody Member member) {
        log.info(member.toString());

        String userId = memberService.join(member);

        return new ResponseEntity<String>(userId, HttpStatus.OK);
    }
}
