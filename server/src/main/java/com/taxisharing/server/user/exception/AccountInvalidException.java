package com.taxisharing.server.user.exception;

import com.taxisharing.server.common.exception.BaseException;

public class AccountInvalidException extends BaseException {
    public static final String ERROR_CODE = "user-008";
    private static final String MESSAGE = "유효하지 않은 계좌입니다.";

    public AccountInvalidException() {
        super(ERROR_CODE, MESSAGE);
    }
}
