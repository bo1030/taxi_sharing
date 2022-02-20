package com.taxisharing.server.payment.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PaymentCompleteResponse {
    private int amount;

    public PaymentCompleteResponse(int amount) {
        this.amount = amount;
    }
}
