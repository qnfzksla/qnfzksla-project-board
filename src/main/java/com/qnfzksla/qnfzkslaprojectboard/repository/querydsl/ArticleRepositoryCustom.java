package com.qnfzksla.qnfzkslaprojectboard.repository.querydsl;

import java.util.List;

public interface ArticleRepositoryCustom {

    List<String> findAllDistinctHashtags();
}
