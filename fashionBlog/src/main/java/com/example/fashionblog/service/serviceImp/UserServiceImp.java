package com.example.fashionblog.service.serviceImp;

import com.example.fashionblog.dto.UserDto;
import com.example.fashionblog.enums.Role;
import com.example.fashionblog.exception.exceptionLoader.UserAlreadyExist;
import com.example.fashionblog.exception.exceptionLoader.UserNotFound;
import com.example.fashionblog.io.UserEntity;
import com.example.fashionblog.repository.UserRepository;
import com.example.fashionblog.service.UserService;
import com.example.fashionblog.shared.Util;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserService {

    private  final UserRepository userRepository;



    private final Util utils;

    @Override
    public UserDto createUser(UserDto user) {

        if(userRepository.findByEmail(user.getEmail()).isPresent()) throw new UserAlreadyExist("User already created.");

        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(user, userEntity);


        String publicUserId = utils.generatedUserId(15);
        userEntity.setRole(Role.ADMIN);
        userEntity.setEncryptedPassword("test");
        userEntity.setUserId(publicUserId);

        UserEntity storedUser = userRepository.save(userEntity);
        UserDto returnValue = new UserDto();
        BeanUtils.copyProperties(storedUser,returnValue);
        return returnValue;
    }

    @Override
    public UserDto login(UserDto userDto) {

        Optional<UserEntity> adminEntity = userRepository.findByEmail(userDto.getEmail());
        if(adminEntity.isEmpty())
            throw new UserNotFound("Kindly register or possible error input");
        UserDto returnValue = new UserDto();
            BeanUtils.copyProperties(adminEntity.get(),returnValue);

        return returnValue;
    }
}
