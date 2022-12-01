package com.example.fashionblog.exception;

import com.example.fashionblog.exception.exceptionLoader.UserAlreadyExist;
import com.example.fashionblog.exception.exceptionLoader.UserNotFound;
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



    @ExceptionHandler(value = {UserNotFound.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Object> handleUserNotFoundException(UserNotFound e){
        ApiException apiException = new ApiException(e.getMessage(), HttpStatus.NOT_FOUND, LocalDateTime.now());

        return new ResponseEntity<>(apiException, HttpStatus.NOT_FOUND);
    }



}
