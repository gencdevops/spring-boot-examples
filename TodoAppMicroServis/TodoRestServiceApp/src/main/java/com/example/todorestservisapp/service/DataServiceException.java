package com.example.todorestservisapp.service;

public class DataServiceException extends RuntimeException {
    public DataServiceException() {
        this((String) null);
    }

    public DataServiceException(String message) {
        this(message, (Throwable) null);
    }

    public DataServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public String getMessage() {
        Throwable cause = this.getCause();
        return String.format("{message : %s%s}", super.getMessage(),
                cause != null ? ", cause message : " + cause.getMessage() : "");
    }
}
