package com.taxisharing.server.user.exception;

import com.taxisharing.server.common.exception.BaseException;

public class DuplicatedUsernameException extends BaseException {
    private static final String ERROR_CODE = "user-001";
    private static final String MESSAGE = "ID가 중복되었습니다.";

    public DuplicatedUsernameException()
    {
        super(ERROR_CODE, MESSAGE);
    }
}
