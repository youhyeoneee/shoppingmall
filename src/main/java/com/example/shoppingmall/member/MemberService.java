package com.example.shoppingmall.member;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Transactional
@Service
@AllArgsConstructor
public class MemberService {

    MemberRepository memberRepository;

    public Member join(Member member) {
        return memberRepository.save(member);
    }

    public boolean checkDuplicateId(String userId) {
        Member existedMember = memberRepository.findById(userId);

        if (existedMember == null)
            return false;
        return true;
    }

}
