package com.taxisharing.server.auth.exception;

import com.taxisharing.server.common.exception.BaseException;

public class AuthorizationHeaderNotFoundException extends BaseException {
    public static final String ERROR_CODE = "auth-003";
    private static final String MESSAGE = "Authorization 헤더를 찾을 수가 없습니다.";

    public AuthorizationHeaderNotFoundException() {
        super(ERROR_CODE, MESSAGE);
    }
}
