package com.generation.www.service;

import com.generation.www.domain.Article;
import com.generation.www.dto.AddArticleRequest;
import com.generation.www.repository.BlogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BlogService {
    private final BlogRepository blogRepository;

    public Article save(AddArticleRequest request) {
        return blogRepository.save(request.toEntity());
    }
}