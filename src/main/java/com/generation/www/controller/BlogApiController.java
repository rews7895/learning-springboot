package com.generation.www.controller;

import com.generation.www.dto.ArticleResponse;
import lombok.RequiredArgsConstructor;
import com.generation.www.domain.Article;
import com.generation.www.dto.AddArticleRequest;
import com.generation.www.service.BlogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class BlogApiController {
    private final BlogService blogService;

    @PostMapping("/api/articles")
    public ResponseEntity<Article> addArticle(@RequestBody AddArticleRequest request) {
        Article savedArticle = blogService.save(request);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedArticle);
    }

    public ResponseEntity<List<ArticleResponse>> findAllArticles() {
        List<ArticleResponse> articles = blogService.findAll().stream().map(ArticleResponse::new).toList();

        return ResponseEntity.ok().body(articles);
    }
}
