package com.example.shoppingmall.member;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class DuplicateException extends RuntimeException {
    String message;
    DuplicateException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
