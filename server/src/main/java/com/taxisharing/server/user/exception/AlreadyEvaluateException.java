package com.taxisharing.server.user.exception;

import com.taxisharing.server.common.exception.BaseException;

public class AlreadyEvaluateException extends BaseException {
    private static final String ERROR_CODE = "user-005";
    private static final String MESSAGE = "이미 평가하였습니다.";

    public AlreadyEvaluateException() {
        super(ERROR_CODE, MESSAGE);
    }
}
