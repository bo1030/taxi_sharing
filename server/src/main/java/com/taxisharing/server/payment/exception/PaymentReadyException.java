package com.taxisharing.server.payment.exception;

import com.taxisharing.server.common.exception.BaseException;

public class PaymentReadyException extends BaseException {
    public static final String ERROR_CODE = "payment-001";
    private static final String MESSAGE = "결제 준비를 할 수 없습니다.";

    public PaymentReadyException() {
        super(ERROR_CODE, MESSAGE);
    }
}
