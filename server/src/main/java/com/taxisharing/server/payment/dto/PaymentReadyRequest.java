package com.taxisharing.server.payment.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PaymentReadyRequest {

    @NotNull
    private int amount;

    public PaymentReadyRequest(int amount) {
        this.amount = amount;
    }
}
