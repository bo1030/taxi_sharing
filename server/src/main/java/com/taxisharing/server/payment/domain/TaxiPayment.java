package com.taxisharing.server.payment.domain;

import com.taxisharing.server.common.domain.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TaxiPayment extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer amount;

    @OneToMany(mappedBy="payment")
    private final List<PointPayment> personalPayments = new ArrayList<>();

    public TaxiPayment(Integer amount) {
        this.amount = amount;
    }
}