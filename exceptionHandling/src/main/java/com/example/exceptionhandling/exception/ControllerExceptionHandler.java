package com.example.exceptionhandling.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerExceptionHandler {
    @ExceptionHandler({EntityNotFoundException.class})
    public String entityNotFound() {
        return "Record not found";
    }

    @ExceptionHandler({IllegalArgumentException.class})
    public String IllegalArgumentEx() {
        return "wrong parameter";
    }

    

}
