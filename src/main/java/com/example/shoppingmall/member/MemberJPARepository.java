package com.example.shoppingmall.member;

import org.springframework.context.annotation.Primary;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Primary
@Repository
public interface MemberJPARepository extends CrudRepository<Member, Integer>, MemberRepository {
}
