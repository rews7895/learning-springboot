package com.generation.www.controller;

import com.generation.www.dao.Member;
import com.generation.www.repository.MemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.junit.jupiter.api.Assertions.*;

// 테스트용 어플리케이션 컨텍스트 생성
@SpringBootTest
// MockMvc 생성 및 자동 구성
@AutoConfigureMockMvc
class TestControllerTest {
    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    private WebApplicationContext context;

    @Autowired
    private MemberRepository memberRepository;

    // 테스트 실행 전 실행하는 메서드
    @BeforeEach
    public void mockMvcSetUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    // 테스트 실행 후 실행하는 메서드
    @AfterEach
    public void cleanUp() {
        memberRepository.deleteAll();
    }

    /**
     * HTTP 주요 응답 코드
     * 200 OK: isOk()
     * 201 Created: isCreated()
     * 400 Bad Request: isBadRequest()
     * 403 Forbidden: isForbidden()
     * 404 Not Found: isNotFound()
     * 400 번대 응답 코드: is4xxClientError()
     * 500 Internal Server Error: isInternalServerError()
     * 500 번대 응답 코드: is5xxServerError()
     */
    @DisplayName("getAllMembers: 아티클 조회에 성공한다.")
    @Test
    public void getAllMembers() throws Exception {
        // given: 멤버를 저장
        final String url = "/test";
        Member savedMember = memberRepository.save(new Member(1L, "홍길동"));

        // when: 멤버 리스트를 조회하는 API를 호출
        // perform(): 요청을 전송하는 역할을 하는 메서드이며, 결과로 ResultActions 객체를 받으며, ResultActions 객체는 반환값을 검증하고 확인하는 andExpect() 메서드를 제공해준다.
        // accept(): 요청을 보낼 때 무슨 타입으로 응답을 받을지 결정하는 메서드
        final ResultActions result = mockMvc.perform(get(url).accept(MediaType.APPLICATION_JSON));

        // then: 응답코드가 200 OK이고, 반환받은 값 중에 0번째 요소의 id와 name이 저장된 값과 같은지 확인
        // andExpect(): 응답을 검증한다.
        // isOk(): 응답 코드 200을 리턴
        // jsonPath("$[0].${필드명}")은 JSON 응답값의 값을 가져오는 역할을 하는 메서드로 0번째 배열에 들어있는 객체의 id, name 값을 가져오고, 저장된 값과 같은지 확인
        result
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(savedMember.getId()))
                .andExpect(jsonPath("$[0].name").value(savedMember.getName()));
    }
}