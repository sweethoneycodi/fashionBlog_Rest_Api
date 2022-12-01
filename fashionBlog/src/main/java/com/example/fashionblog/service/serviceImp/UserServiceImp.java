package com.example.fashionblog.service.serviceImp;

import com.example.fashionblog.dto.UserDto;
import com.example.fashionblog.exception.exceptionLoader.UserAlreadyExist;
import com.example.fashionblog.io.UserEntity;
import com.example.fashionblog.repository.UserRepository;
import com.example.fashionblog.service.UserService;
import com.example.fashionblog.shared.Util;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserService {

    private  final UserRepository userRepository;


    private final Util utils;

    @Override
    public UserDto createUser(UserDto user) {

        if(userRepository.findByEmail(user.getEmail()).isPresent()) throw new UserAlreadyExist("User already created.");

        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(user,userEntity);


        String publicUserId = utils.generatedUserId(15);

        userEntity.setEncryptedPassword("test");
        userEntity.setUserId(publicUserId);

        UserEntity storedUser = userRepository.save(userEntity);
        UserDto returnValue = new UserDto();
        BeanUtils.copyProperties(storedUser,returnValue);
        return returnValue;
    }
}
