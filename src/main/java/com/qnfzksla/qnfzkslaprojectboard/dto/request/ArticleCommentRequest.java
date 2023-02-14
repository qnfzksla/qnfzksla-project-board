package com.qnfzksla.qnfzkslaprojectboard.dto.request;

import com.qnfzksla.qnfzkslaprojectboard.dto.ArticleCommentDto;
import com.qnfzksla.qnfzkslaprojectboard.dto.UserAccountDto;

public record ArticleCommentRequest(Long articleId, String content) {
    public static  ArticleCommentRequest of(Long articleId, String content){
        return  new ArticleCommentRequest(articleId, content);
    }

    public ArticleCommentDto toDto(UserAccountDto userAccountDto){
        return  ArticleCommentDto.of(
                articleId,
                userAccountDto,
                content
        );
    }
}
