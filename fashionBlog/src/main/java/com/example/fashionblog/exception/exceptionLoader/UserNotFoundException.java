package com.example.fashionblog.exception.exceptionLoader;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String message) {
        super(message);
    }
}
