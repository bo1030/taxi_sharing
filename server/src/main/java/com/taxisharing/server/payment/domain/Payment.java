package com.taxisharing.server.payment.domain;

import com.taxisharing.server.common.domain.BaseTimeEntity;
import com.taxisharing.server.payment.dto.PaymentInfo;
import com.taxisharing.server.payment.exception.IllegalPaymentInfoException;
import com.taxisharing.server.user.domain.User;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name="payment")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Payment extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer amount;

    @Enumerated(value = EnumType.ORDINAL)
    private PaymentStatus status;

    private UUID merchantUid;

    private String impUid;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    private Payment(Integer amount, PaymentStatus status, UUID merchantUid, String impUid) {
        this.amount = amount;
        this.status = status;
        this.merchantUid = merchantUid;
        this.impUid = impUid;
    }

    public Payment(Integer amount)
    {
        this(amount, PaymentStatus.READY, UUID.randomUUID(),null);
    }

    public void to(User user) {
        this.user = user;
    }

    public void complete(PaymentInfo paymentInfo) {
        validatePayment(paymentInfo);
        this.impUid = paymentInfo.getImp_uid();
        this.status = PaymentStatus.PAID;
        this.user.increasePoint(paymentInfo.getAmount());
    }

    private void validatePayment(PaymentInfo paymentInfo) {
        if (paymentInfo.getStatus() != PaymentStatus.PAID)
        {
            updateStatus(PaymentStatus.INVALID);
            throw IllegalPaymentInfoException.from(IllegalPaymentInfoException.ERROR_CODE_NOT_PAID);
        }

        if (!amount.equals(paymentInfo.getAmount())) {
            updateStatus(PaymentStatus.INVALID);
            throw IllegalPaymentInfoException.from(IllegalPaymentInfoException.ERROR_CODE_INVALID_AMOUNT);
        }
    }

    private void updateStatus(PaymentStatus status){
        this.status = status;
    }
}
