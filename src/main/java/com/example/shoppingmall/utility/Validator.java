package com.example.shoppingmall.utility;

import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

@Component
public class Validator {

    public static boolean isAlpha(String str) {
        return Pattern.matches("^[a-zA-Z]*$", str);
    }

    public static boolean isNumber(int number) {
        return Pattern.matches("^[0-9]*$", Integer.toString(number));
    }
}
