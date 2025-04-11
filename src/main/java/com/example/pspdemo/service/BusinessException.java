package com.example.pspdemo.service;

public class BusinessException extends Throwable {
    private String message;

    public BusinessException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
