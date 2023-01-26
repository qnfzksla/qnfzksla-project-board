package com.qnfzksla.qnfzkslaprojectboard.repository;

import com.qnfzksla.qnfzkslaprojectboard.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ArticleRepository extends JpaRepository<Article, Long> {
}