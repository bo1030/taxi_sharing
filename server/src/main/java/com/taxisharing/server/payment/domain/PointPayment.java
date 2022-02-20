package com.taxisharing.server.payment.domain;

import com.taxisharing.server.user.domain.User;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="point_payment")
@IdClass(PointPaymentId.class)
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PointPayment {
    @Id
    @ManyToOne(fetch= FetchType.LAZY) //필요할 때만
    @JoinColumn(name = "taxi_payment_id")
    private TaxiPayment payment;


    @Id
    @ManyToOne(fetch= FetchType.EAGER) //항상 들고오는
    @JoinColumn(name = "user_id")
    private User user;

    private Integer personalAmount;

    public PointPayment(Integer personalAmount){
        this.personalAmount=personalAmount;
    }
}
