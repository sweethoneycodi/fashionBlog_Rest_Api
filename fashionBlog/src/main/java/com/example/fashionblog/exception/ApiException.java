package com.example.fashionblog.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Setter
public class ApiException {
    private final String message;
    private final HttpStatus httpStatus;
    private final LocalDateTime time;
}
