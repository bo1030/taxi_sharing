package com.taxisharing.server.payment.dto;

import com.taxisharing.server.payment.domain.Payment;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PaymentReadyResponse {
    private UUID merchantUid;
    private int amount;

    public PaymentReadyResponse(UUID merchantUid, int amount) {
        this.merchantUid = merchantUid;
        this.amount = amount;
    }

    public PaymentReadyResponse(Payment payment)
    {
        this(payment.getMerchantUid(),payment.getAmount());
    }
}
