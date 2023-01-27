package com.qnfzksla.qnfzkslaprojectboard.domain;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@ToString
@Table(indexes = {
        @Index(columnList = "content"),
        @Index(columnList = "createdAt"),
        @Index(columnList = "createdBy")
})

@Entity
public class ArticleComment extends AuditingFields{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Setter @ManyToOne(optional = false) private Article article; // 게시글
    @Setter @Column(nullable = false, length = 500) private String content; // 본문
    @Setter private String hashtag; // 해시테그



    protected ArticleComment(){}

    private ArticleComment( Article article, String content ) {

        this.article = article;
        this.hashtag = hashtag;
    }

    public static  ArticleComment of(Article article, String content) {
        return  new ArticleComment(article,content);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArticleComment that = (ArticleComment) o;
        return id != null && id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
