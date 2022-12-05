package com.example.fashionblog.controllers;

import com.example.fashionblog.dto.UserDto;
import com.example.fashionblog.enums.Role;
import com.example.fashionblog.pojo.request.CreateAdminRequest;
import com.example.fashionblog.pojo.request.LoginRest;
import com.example.fashionblog.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.http.ResponseEntity.status;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BlogUserController.class)
class BlogUserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    @MockBean
    private UserService userServiceImp;

    @AfterEach
    void tearDown() {
    }

//    @Test
//    void createUser() throws Exception {
//        CreateAdminRequest createAdminRequest = new CreateAdminRequest();
//        createAdminRequest.setFirstName("samuel");
//        createAdminRequest.setLastName("sam");
//        createAdminRequest.setEmail("samdoe@gmail.com");
//        createAdminRequest.setPassword("12345");
////        UserDto userDto = new UserDto();
////        userDto.setFirstName("pat");
////        userDto.setLastName("john");
////        userDto.setEmail("jameshope@gmail.com");
////        userDto.setPassword("1234");
////        userDto.setEncryptedPassword("23edft5");
////        userDto.setEmailVerificationToken("weed");
////        userDto.setEmailVerificationStatus(false);
//
//        String pass = mapper.writeValueAsString(createAdminRequest);
//
//        mockMvc.perform(post("/api/v1/blogUser/createdUser", 42L)
//                        .contentType("application/json")
//                        .content(pass))
//                        .andExpect(status().isCreated());
//    }
//
//    @Test
//    void loginAdmin() throws Exception{
//        LoginRest loginRest = new LoginRest();
//        loginRest.setEmail("kegs@gmail.com");
//        loginRest.setPassword("1234");
//
//        String pass = mapper.writeValueAsString(loginRest);
//
//        mockMvc.perform(post("/api/v1/blogUser/login", 42L)
//                .contentType("application/json")
//                .content(pass))
//                .andExpect(status().isAccepted());
//    }
}