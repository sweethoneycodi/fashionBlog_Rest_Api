package com.example.fashionblog.exception;

import com.example.fashionblog.exception.exceptionLoader.UserAlreadyExist;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
@RequiredArgsConstructor
public class APIExceptionHandler {

    @ExceptionHandler(value = {UserAlreadyExist.class})
    @ResponseStatus(HttpStatus.CONFLICT)
    public ResponseEntity<Object> handleUserAlreadyExistException(UserAlreadyExist exist){
        ApiException apiException = new ApiException(exist.getMessage(), HttpStatus.CONFLICT, LocalDateTime.now());

        return new ResponseEntity<>(apiException, HttpStatus.CONFLICT);
    }



}
