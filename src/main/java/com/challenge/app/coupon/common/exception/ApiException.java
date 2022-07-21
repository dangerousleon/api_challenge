package com.challenge.app.coupon.common.exception;

import org.springframework.http.HttpStatus;

public class ApiException extends RuntimeException {
    String message;

    public ApiException(String message) {
        super(message);
    }
}
