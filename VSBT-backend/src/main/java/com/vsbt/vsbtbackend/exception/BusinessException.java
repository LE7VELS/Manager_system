package com.vsbt.vsbtbackend.exception;

public class BusinessException extends RuntimeException{
    public BusinessException(String message) {
        super(message);
    }
}

