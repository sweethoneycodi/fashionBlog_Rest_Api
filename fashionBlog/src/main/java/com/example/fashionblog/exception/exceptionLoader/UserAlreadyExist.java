package com.example.fashionblog.exception.exceptionLoader;

public class UserAlreadyExist extends RuntimeException{
    public UserAlreadyExist(String message) {
        super(message);
    }
}
