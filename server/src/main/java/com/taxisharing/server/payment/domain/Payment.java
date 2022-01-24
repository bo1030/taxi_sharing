package com.taxisharing.server.payment.domain;

import com.taxisharing.server.user.domain.User;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private Date time;

    private Integer amount;

    public Payment(Date time, Integer amount) {
        this.time = time;
        this.amount = amount;
    }

    public Payment(Integer amount){
        this(new Date(System.currentTimeMillis()),amount);
    }

}