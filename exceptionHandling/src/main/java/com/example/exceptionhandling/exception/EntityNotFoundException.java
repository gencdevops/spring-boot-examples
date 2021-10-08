package com.example.exceptionhandling.exception;

public class EntityNotFoundException extends RuntimeException{
    public EntityNotFoundException(String param) {
        super(param);
    }
}
