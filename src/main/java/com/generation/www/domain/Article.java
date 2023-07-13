package com.generation.www.domain;


import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "content", nullable = false)
    private String content;

    // @Builder: 롬복에서 지원하는 어노테이션으로 빌터 패턴 방식으로 객체를 편리하게 생성할 수 있게 해준다.
    @Builder
    public Article(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
