package com.taxisharing.server.payment.domain;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.io.Serializable;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PersonalPaymentId implements Serializable {
    private int user;
    private int payment;

    public PersonalPaymentId(int user, int payment)
    {
        this.payment = payment;
        this.user = user;
    }
}
