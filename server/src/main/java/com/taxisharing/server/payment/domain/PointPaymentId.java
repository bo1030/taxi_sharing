package com.taxisharing.server.payment.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PointPaymentId implements Serializable {
    private int user;
    private int payment;

    public PointPaymentId(int user, int payment)
    {
        this.payment = payment;
        this.user = user;
    }
}
