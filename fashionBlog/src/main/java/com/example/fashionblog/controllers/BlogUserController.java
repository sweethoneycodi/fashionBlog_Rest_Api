package com.example.fashionblog.controllers;

import com.example.fashionblog.dto.UserDto;
import com.example.fashionblog.pojo.request.CreateUserRequest;
import com.example.fashionblog.pojo.response.CreateUserRest;
import com.example.fashionblog.service.UserService;
import com.example.fashionblog.service.serviceImp.UserServiceImp;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@AllArgsConstructor
@RestController
@RequestMapping("api/v1/blogUser")  // http://localhost:8080/api/v1/blogUser/createdUser
public class BlogUserController {
    private final UserService userServiceImp;
    @PostMapping("/createdUser")
    public CreateUserRest createUser(@Valid @RequestBody CreateUserRequest createUserRequest) {
        CreateUserRest returnValue = new CreateUserRest();

        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(createUserRequest,userDto);

        UserDto created = userServiceImp.createUser(userDto);
        BeanUtils.copyProperties(created,returnValue);

        return returnValue;
    }
}
