package com.sparta.selecthing.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public class CustomExcepton extends RuntimeException{
    private final HttpStatus httpStatus;
}
