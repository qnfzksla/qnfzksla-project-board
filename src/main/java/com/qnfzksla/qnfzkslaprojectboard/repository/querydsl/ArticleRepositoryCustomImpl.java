package com.qnfzksla.qnfzkslaprojectboard.repository.querydsl;

import com.qnfzksla.qnfzkslaprojectboard.domain.Article;
import com.qnfzksla.qnfzkslaprojectboard.domain.QArticle;
import com.querydsl.jpa.JPQLQuery;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

public class ArticleRepositoryCustomImpl extends QuerydslRepositorySupport implements ArticleRepositoryCustom {

    public ArticleRepositoryCustomImpl() {
        super(Article.class);
    }

    @Override
    public List<String> findAllDistinctHashtags() {

        QArticle article = QArticle.article;


        return  from(article)
                .distinct()
                .select(article.hashtag)
                .where(article.hashtag.isNotNull())
                .fetch();
    }
}
