package com.taxisharing.server.payment.util;

import com.taxisharing.server.payment.dto.PaymentInfo;

import java.util.UUID;

public interface PaymentConnector {
    PaymentInfo requestPaymentInfo(UUID merchantUid);

    PaymentInfo requestPaymentRefund(UUID merchantUid);

    String requestAccountHolder(String bankCode, String bankNum);
}
