package com.taxisharing.server.user.exception;

import com.taxisharing.server.common.exception.BaseException;

public class UserBanException extends BaseException {
    private static final String ERROR_CODE = "user-004";
    private static final String MESSAGE = "차단 실패하였습니다.";

    public UserBanException() {
        super(ERROR_CODE, MESSAGE);
    }
}
