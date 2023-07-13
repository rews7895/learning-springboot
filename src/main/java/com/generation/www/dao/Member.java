package com.generation.www.dao;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

// 기본 생성자
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
// 엔티티로 지정
@Entity
// 엔티티 테이블 매핑
//@Entity(name = "member_list")
public class Member {
    
    // DB 테이블의 'id' 컬럼과 매칭 (기본키)
    @Id
    // 기본키를 자동으로 1씩 증가
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;
    
    // DB 테이블의 'name' 컬럼과 매칭
    @Column(name = "name", nullable = false)
    private String name;
}
