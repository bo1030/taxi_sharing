package com.taxisharing.server.payment.domain;

import com.taxisharing.server.user.domain.User;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.boot.web.embedded.undertow.UndertowServletWebServer;

import javax.persistence.*;

@Entity
@Table(name="personal_payment")
@IdClass(PersonalPaymentId.class)
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PersonalPayment {
    @Id
    @ManyToOne(fetch= FetchType.LAZY) //필요할 때만
    @JoinColumn(name = "payment_id")
    private Payment payment;


    @Id
    @ManyToOne(fetch= FetchType.EAGER) //항상 들고오는
    @JoinColumn(name = "user_id")
    private User user;

    private Integer personalAmount;

    public PersonalPayment(Integer personalAmount){
        this.personalAmount=personalAmount;
    }
}
