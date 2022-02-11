package com.taxisharing.server.user.exception;

import com.taxisharing.server.common.exception.BaseException;

public class NicknameValidationException extends BaseException {
    private static final String ERROR_CODE = "user-006";
    private static final String MESSAGE = "닉네임 형식이 잘못되었습니다.";

    public NicknameValidationException()
    {
        super(ERROR_CODE, MESSAGE);
    }
}
