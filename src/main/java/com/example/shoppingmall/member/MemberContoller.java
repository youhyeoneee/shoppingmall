package com.example.shoppingmall.member;

import com.example.shoppingmall.utils.ApiUtils;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

import static com.example.shoppingmall.utils.ApiUtils.error;
import static com.example.shoppingmall.utils.ApiUtils.success;

@Slf4j
@AllArgsConstructor
@RestController
public class MemberContoller {
    MemberService memberService;

    @PostMapping("/join")
    public ApiUtils.ApiResult join(@Valid @RequestBody MemberDTO memberDto) {
        if (isDuplicateId(memberDto)) {
            return error("아이디 중복", HttpStatus.CONFLICT);
        }

        Member requestMember = memberDto.convertToEntity();
        String userId = memberService.join(requestMember);
        return success(userId);
    }

    boolean isDuplicateId(MemberDTO memberDto) {
        return memberService.checkDuplicateId(memberDto.getUserId());
    }

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
        return error(errorMessages, HttpStatus.BAD_REQUEST);
    }
}
