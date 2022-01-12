package com.taxisharing.server.auth.exception;

import com.taxisharing.server.common.exception.BaseException;

public class InvalidIdOrPassword extends BaseException {
    private static final String ERROR_CODE = "auth-001";
    private static final String MESSAGE = "로그인 정보가 일치하지 않습니다.";

    public InvalidIdOrPassword()
    {
        super(ERROR_CODE, MESSAGE);
    }
}
