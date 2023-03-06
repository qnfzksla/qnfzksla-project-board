package com.fastcampus.projectboard.controller;

import com.fastcampus.projectboard.dto.response.ArticleCommentResponse;
import com.fastcampus.projectboard.dto.response.ArticleWithCommentsResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;

@Controller
public class MainController {

    @GetMapping("/")
    public  String root(){
        return  "forward:/articles";
    }

    @GetMapping("/test-rest")
    public ArticleCommentResponse test(){
        return ArticleCommentResponse.of(
                1L,
                "content",
                LocalDateTime.now(),
                "e@mail.com",
                "Uno",
                "uno"
        );
    }
}
