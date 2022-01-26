package com.taxisharing.server.user.exception;

import com.taxisharing.server.common.exception.BaseException;

public class UserNotFoundException extends BaseException {
    private static final String ERROR_CODE = "user-003";
    private static final String MESSAGE = "해당 회원을 찾을 수 없습니다.";

    public UserNotFoundException()
    {
        super(ERROR_CODE, MESSAGE);
    }
}
