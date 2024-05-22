package com.example.shoppingmall.member;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MemberService {

    MemberRepository memberRepository;

    @Transactional
    public String join(Member member) {
        memberRepository.save(member);
        Optional<Member> resultMember = memberRepository.findByUserId(member.getUserId());
        if (resultMember.isEmpty())
            return "실패";
        return resultMember.get().getUserId();
    }

    public boolean checkDuplicateId(String userId) {
        Optional<Member> existedMember = memberRepository.findByUserId(userId);

        if (existedMember.isEmpty())
            return false;
        return true;
    }

    public String login(String userId, String password) {
        Optional<Member> resultMember = memberRepository.findByUserIdAndPw(userId, password);
        if (resultMember.isEmpty())
            return null;
        return resultMember.get().getUserId();
    }
}
