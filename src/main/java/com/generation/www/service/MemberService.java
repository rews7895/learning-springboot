package com.generation.www.service;

import com.generation.www.dao.Member;
import com.generation.www.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {
    @Autowired
    MemberRepository memberRepository;

    public void test() {
        // 생성
        memberRepository.save(new Member(1L, "A"));

        // 조회
        Optional<Member> member = memberRepository.findById(1L);
        // 전체 조회
        List<Member> allMembers = memberRepository.findAll();

        // 삭제
        memberRepository.deleteById(1L);

        // 삭제
        memberRepository.delete(new Member(1L, "A"));
    }
}
