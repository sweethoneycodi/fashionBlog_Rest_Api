package com.example.fashionblog.exception.exceptionLoader;

public class PostNotFoundException extends RuntimeException{
    public PostNotFoundException(String message) {
        super(message);
    }
}
