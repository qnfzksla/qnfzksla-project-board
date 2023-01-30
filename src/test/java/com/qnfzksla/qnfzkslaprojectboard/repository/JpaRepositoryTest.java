package com.qnfzksla.qnfzkslaprojectboard.repository;

import com.qnfzksla.qnfzkslaprojectboard.config.JpaConfig;
import com.qnfzksla.qnfzkslaprojectboard.domain.Article;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@DisplayName("JPA 연결 테스트")
@Import(JpaConfig.class)
@DataJpaTest
class JpaRepositoryTest {

    private ArticleRepository articleRepository;
    private ArticleCommentRepository articleCommentRepository;

    public JpaRepositoryTest(
         @Autowired ArticleRepository articleRepository,
         @Autowired ArticleCommentRepository articleCommentRepository
    ) {
        this.articleRepository = articleRepository;
        this.articleCommentRepository = articleCommentRepository;
    }

    @Disabled("구현중")
    @DisplayName("select 테스트")
    @Test
    void  givenTestData_whenSelecting_thenWorksFine(){

        //Given

        //when
        List<Article> articles = articleRepository.findAll();
        //Then
       assertThat(articles)
               .isNotNull()
               .hasSize(123);

    }

    @DisplayName("insert 테스트")
    @Test
    void  givenTestData_whenInserting_thenWorksFine(){

        //Given
        long previousCout = articleRepository.count();
        //when
        Article savedArticle = articleRepository.save(Article.of("new article", "new content", "#spring"));
        //Then
        assertThat(articleRepository.count()).isEqualTo(previousCout + 1);

    }

    @DisplayName("update 테스트")
    @Test
    void  givenTestData_whenUpdating_thenWorksFine(){

        //Given
        Article article = articleRepository.findById(1L).orElseThrow();
        String updatedHashtag = "#springboot";
        article.setHashtag(updatedHashtag);
        //when
        Article savedArticle = articleRepository.save(article);
        //Then
        assertThat(savedArticle).hasFieldOrPropertyWithValue("hashtag", updatedHashtag);

    }

    @DisplayName("delete 테스트")
    @Test
    void  givenTestData_whendeleting_thenWorksFine(){

        //Given
        Article article = articleRepository.findById(1L).orElseThrow();
        long previousArticleCount = articleRepository.count();
        long previousArticleCommentCount = articleCommentRepository.count();
        int deletedCommentsSize = article.getArticleComments().size();
        //when
        articleRepository.delete(article);
        //Then
        assertThat(articleRepository.count()).isEqualTo(previousArticleCount - 1);
        assertThat(articleCommentRepository.count()).isEqualTo(previousArticleCommentCount - deletedCommentsSize);

    }
}