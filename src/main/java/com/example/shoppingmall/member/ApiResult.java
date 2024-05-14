package com.example.shoppingmall.member;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;


@Getter
@AllArgsConstructor
public class ApiResult<T> {
    boolean success;
    T response;
    ApiError error;

    @AllArgsConstructor
    @Getter
    static class ApiError {
        String message;
        HttpStatus status;
    }

}


