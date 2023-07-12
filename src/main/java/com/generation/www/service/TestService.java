package com.generation.www.service;

import com.generation.www.dao.Member;
import com.generation.www.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService {
    // 빈 주입
    @Autowired
    MemberRepository memberRepository;

    // 멤버 목록 얻기
    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }
}
