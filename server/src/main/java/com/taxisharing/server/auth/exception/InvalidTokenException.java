package com.taxisharing.server.auth.exception;

import com.taxisharing.server.common.exception.BaseException;

public class InvalidTokenException extends BaseException {

    public static final String ERROR_CODE = "auth-002";
    private static final String MESSAGE = "유효하지 않은 토큰입니다.";

    public InvalidTokenException()
    {
        super(ERROR_CODE, MESSAGE);
    }
}
