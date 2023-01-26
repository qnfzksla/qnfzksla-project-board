package com.qnfzksla.qnfzkslaprojectboard.repository;

import com.qnfzksla.qnfzkslaprojectboard.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {
}