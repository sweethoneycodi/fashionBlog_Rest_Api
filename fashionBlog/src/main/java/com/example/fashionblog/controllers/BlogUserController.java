package com.example.fashionblog.controllers;

import com.example.fashionblog.dto.UserDto;
import com.example.fashionblog.pojo.request.CreateAdminRequest;
import com.example.fashionblog.pojo.request.LoginRest;
import com.example.fashionblog.pojo.response.CreateAdminRest;
import com.example.fashionblog.service.UserService;
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
    public CreateAdminRest createUser(@Valid @RequestBody CreateAdminRequest createAdminRequest) {
        CreateAdminRest returnValue = new CreateAdminRest();

        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(createAdminRequest,userDto);

        UserDto created = userServiceImp.createUser(userDto);
        BeanUtils.copyProperties(created,returnValue);

        return returnValue;
    }
    @PostMapping("/login")
    public LoginRest loginAdmin(@Valid @RequestBody LoginRest request) {
        LoginRest returnValue =  new LoginRest();

        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(request,userDto);

        UserDto found = userServiceImp.login(userDto);
        BeanUtils.copyProperties(found,returnValue);

        return returnValue;
    }
}
