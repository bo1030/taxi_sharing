package com.taxisharing.server.user.exception;

import com.taxisharing.server.common.exception.BaseException;

public class PasswordValidationException extends BaseException {
    private static final String ERROR_CODE = "user-007";
    private static final String MESSAGE = "Password 형식이 잘못되었습니다.";

    public PasswordValidationException()
    {
        super(ERROR_CODE, MESSAGE);
    }
}
