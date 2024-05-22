package com.example.shoppingmall.member;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MemberService {

    MemberRepository memberRepository;

    @Transactional
    public String join(Member member) {
        memberRepository.save(member);

        return memberRepository.findByUserId(member.getUserId()).getUserId();
    }

    public boolean checkDuplicateId(String userId) {
        Member existedMember = memberRepository.findByUserId(userId);

        if (existedMember == null)
            return false;
        return true;
    }

    public Member login(String userId, String password) {
        List<Member> member = memberRepository.findsByUserIdPw(userId, password);
        if (member.isEmpty())
            return null;
        return member.get(0);
    }
}
