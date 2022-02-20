package com.taxisharing.server.payment.exception;

import com.taxisharing.server.common.exception.BaseException;

public class InvalidMerchantUidException extends BaseException {
    public static final String ERROR_CODE = "payment-003";
    private static final String MESSAGE = "해당 결제를 찾을 수 없습니다.";

    public InvalidMerchantUidException() {
        super(ERROR_CODE, MESSAGE);
    }
}
