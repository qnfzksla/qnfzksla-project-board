package com.fastcampus.projectboard.controller;


import com.fastcampus.projectboard.config.TestSecurityConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@DisplayName("view 컨트롤러 - 인증")
@Import(TestSecurityConfig.class)
@WebMvcTest(Void.class)
public class AuthControllerTest {


    private  final MockMvc mvc;

    public AuthControllerTest(@Autowired MockMvc mvc){
        this.mvc = mvc;
    }


    @DisplayName("[view] [GET] 로그인 페이지 - 정상 호출")
    @Test
    public  void givenNothing_whenTryingToLogin_thenReturnsLogInView() throws Exception {

        //Given

        // when & then
        mvc.perform(get("/login"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_HTML))
                .andDo((MockMvcResultHandlers.print()));

    }

//    @DisplayName("[view] [GET] 게시글 리스트 상세 페이지 - 정상 호출")
//    @Test
//    public  void givenNothing_whenRequestingArticleView_thenReturnsArticleView() throws Exception {
//
//        //Given
//
//        // when & then
//        mvc.perform(get("/articles/1"))
//                .andExpect(status().isOk())
//                .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_HTML))
//                .andExpect(view().name("articles/detail"))
//                .andExpect(model().attributeExists("article"))
//                .andExpect(model().attributeExists("articleComments"));
//    }

}
