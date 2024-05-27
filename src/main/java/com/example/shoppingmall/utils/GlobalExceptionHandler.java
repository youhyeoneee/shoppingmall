package com.example.shoppingmall.utils;


import com.example.shoppingmall.member.DuplicateMemberIdException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import static com.example.shoppingmall.utils.ApiUtils.error;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    // 유효성 검사하다가 에러가 터지면 호출되는 예외 처리 메서드
    @ExceptionHandler//(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiUtils.ApiResult<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException errors) {
        Map<String, String> errorMessages = new HashMap<>();
        for (FieldError error : errors.getFieldErrors()) {
            String errorField = error.getField();
            String errorMessage = error.getDefaultMessage();
            errorMessages.put(errorField, errorMessage);
        }
        log.info("errorMessages={}", errorMessages);
        return error(errorMessages, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.CONFLICT)
    public ApiUtils.ApiResult<String> handleDuplicateMemberIdException(DuplicateMemberIdException error) {
        String errorMessage = error.getMessage();
        return error(errorMessage, HttpStatus.CONFLICT);
    }
    
}
