package com.example.fashionblog.service;

import com.example.fashionblog.dto.UserDto;
import org.apache.catalina.UserDatabase;

public interface UserService {
    UserDto createUser(UserDto user);
}
