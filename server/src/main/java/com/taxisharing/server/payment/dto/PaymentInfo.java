package com.taxisharing.server.payment.dto;

import com.taxisharing.server.payment.domain.PaymentStatus;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PaymentInfo {
    private PaymentStatus status;
    private String merchant_uid;
    private int amount;
    private String name;
    private String imp_uid;

    public PaymentInfo(PaymentStatus status, String merchant_uid, int amount, String name, String imp_uid) {
        this.status = status;
        this.merchant_uid = merchant_uid;
        this.amount = amount;
        this.name = name;
        this.imp_uid = imp_uid;
    }
}
