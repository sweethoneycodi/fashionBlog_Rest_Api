package com.example.fashionblog.exception.exceptionLoader;

public class CommentNotFoundException extends RuntimeException{
    public CommentNotFoundException(String message) {
        super(message);
    }
}
