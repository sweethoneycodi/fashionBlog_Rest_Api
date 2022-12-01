package com.example.fashionblog.exception.exceptionLoader;

public class UserNotFound extends RuntimeException{
    public UserNotFound(String message) {
        super(message);
    }
}
