package com.example.shoppingmall.member;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MemberService {

    MemberRepository memberRepository;

    public String join(Member member) {
        return memberRepository.save(member);
    }

    public boolean checkDuplicateId(String userId) {
        Member existedMember = memberRepository.findById(userId);

        if (existedMember == null)
            return false;
        return true;
    }

    public void makeConnection() {
        memberRepository.makeConnection();
    }
}
