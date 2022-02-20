package com.taxisharing.server.common.exception;

public class HttpConnectionException extends BaseException {
    private static final String ERROR_CODE = "common-001";
    private static final String MESSAGE = "SERVER TIME OUT";

    public HttpConnectionException() {
        super(ERROR_CODE, MESSAGE);
    }
}
