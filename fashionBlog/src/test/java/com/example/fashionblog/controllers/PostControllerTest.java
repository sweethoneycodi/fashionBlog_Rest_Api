package com.example.fashionblog.controllers;

import com.example.fashionblog.dto.PostDto;
import com.example.fashionblog.service.PostService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PostController.class)
class PostControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    @MockBean
    private PostService postServiceImp;

    @AfterEach
    void tearDown() {
    }

    @Test
    void createPost() throws Exception {
        PostDto postDto = new PostDto();
        postDto.setTitle("hello");
        postDto.setDescription("john is mad");
        postDto.setImage("man");

        String pass = mapper.writeValueAsString(postDto);

        mockMvc.perform(post("/api/v1/post/createPost",42L)
                .contentType("application/json").content(pass))
                .andExpect(status().isCreated());
    }

}