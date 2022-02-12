package com.taxisharing.server.payment.domain;

import com.taxisharing.server.common.domain.BaseTimeEntity;
import com.taxisharing.server.user.domain.User;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Payment extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer amount;

    @OneToMany(mappedBy="payment")
    private final List<PersonalPayment> personalPayments = new ArrayList<>();

    public Payment(Integer amount) {
        this.amount = amount;
    }
}