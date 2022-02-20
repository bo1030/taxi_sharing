package com.taxisharing.server.payment.exception;

import com.taxisharing.server.common.exception.BaseException;

public class PaymentCompleteException extends BaseException {
    public static final String ERROR_CODE = "payment-002";
    private static final String MESSAGE = "결제 완료를 할 수 없습니다.";

    public PaymentCompleteException() {
        super(ERROR_CODE, MESSAGE);
    }
}
