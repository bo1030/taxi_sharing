package com.taxisharing.server.payment.domain;

public enum PaymentStatus {
    READY("미결제"), PAID("결제완료"), CANCELLED("결제취소"), FAILED("결제실패"),
    INVALID("위변조검증실패");

    private final String information;

    PaymentStatus(String information) {
        this.information = information;
    }
}
