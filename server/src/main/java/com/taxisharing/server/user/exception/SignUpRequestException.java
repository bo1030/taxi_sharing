package com.taxisharing.server.user.exception;

import com.taxisharing.server.common.exception.BaseException;

public class SignUpRequestException extends BaseException {
    private static final String ERROR_CODE = "user-002";
    private static final String MESSAGE = "회원가입 Request의 값이 유효한 값이 아닙니다.";

    public SignUpRequestException() {
        super(ERROR_CODE, MESSAGE);
    }
}
