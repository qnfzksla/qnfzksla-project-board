package com.qnfzksla.qnfzkslaprojectboard.repository;

import com.qnfzksla.qnfzkslaprojectboard.config.JpaConfig;
import com.qnfzksla.qnfzkslaprojectboard.domain.Article;
import com.qnfzksla.qnfzkslaprojectboard.domain.UserAccount;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import java.util.List;

import static com.qnfzksla.qnfzkslaprojectboard.domain.QArticle.article;
import static org.assertj.core.api.Assertions.assertThat;


@DisplayName("JPA 연결 테스트")
@Import(JpaConfig.class)
@DataJpaTest
class JpaRepositoryTest {

    private final ArticleRepository articleRepository;
    private final ArticleCommentRepository articleCommentRepository;

    private  final  UserAccountRepository userAccountRepository;

    public JpaRepositoryTest(
            @Autowired ArticleRepository articleRepository,
            @Autowired ArticleCommentRepository articleCommentRepository,
            @Autowired UserAccountRepository userAccountRepository
    ) {
        this.articleRepository = articleRepository;
        this.articleCommentRepository = articleCommentRepository;
        this.userAccountRepository = userAccountRepository;
    }

  @Disabled("연결중")
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
        UserAccount userAccount =
                userAccountRepository.save(UserAccount.of("uno","pw",null,null,null));
        Article article = Article.of(userAccount,"new article","new content","#spring");
        //when
       articleRepository.save(article);
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
    void  givenTestData_whenDeleting_thenWorksFine(){

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