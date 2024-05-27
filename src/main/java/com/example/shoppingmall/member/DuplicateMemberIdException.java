package com.example.shoppingmall.member;

public class DuplicateMemberIdException extends RuntimeException {
    String message;
    DuplicateMemberIdException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
