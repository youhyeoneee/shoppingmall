package com.example.shoppingmall.member;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@AllArgsConstructor
public class MemberService {

    MemberRepository memberRepository;

    @Transactional
    public String join(MemberDTO memberDto) {
        Member requestMember = memberDto.convertToEntity();
        Member joinedMember = memberRepository.save(requestMember);
        return joinedMember.getUserId();
    }

    public boolean checkDuplicateId(String userId) {
        Optional<Member> existedMember = memberRepository.findByUserId(userId);

        if (existedMember.isPresent()) {
            log.info(existedMember.get().getUserId());
            return true;
        }
        else
            return false;
    }

    public String login(String userId, String password) {
        Optional<Member> resultMember = memberRepository.findByUserIdAndPw(userId, password);
        if (resultMember.isEmpty())
            return null;
        return resultMember.get().getUserId();
    }
}
