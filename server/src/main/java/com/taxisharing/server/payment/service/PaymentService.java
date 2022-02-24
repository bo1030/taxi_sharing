package com.taxisharing.server.payment.service;


import com.taxisharing.server.payment.domain.Payment;
import com.taxisharing.server.payment.dto.PaymentCompleteRequest;
import com.taxisharing.server.payment.dto.PaymentCompleteResponse;
import com.taxisharing.server.payment.dto.PaymentInfo;
import com.taxisharing.server.payment.dto.PaymentReadyResponse;
import com.taxisharing.server.payment.exception.InvalidMerchantUidException;
import com.taxisharing.server.payment.repository.PaymentRepository;
import com.taxisharing.server.payment.util.PaymentConnector;
import com.taxisharing.server.user.domain.User;
import com.taxisharing.server.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;


@Service
@Transactional
@RequiredArgsConstructor
public class PaymentService {
    private final PaymentRepository paymentRepository;
    private final UserService userService;
    private final PaymentConnector paymentConnector;

    public PaymentCompleteResponse completePayment(int uid, PaymentCompleteRequest paymentCompleteRequest) {
        UUID merchantUid = UUID.fromString(paymentCompleteRequest.getMerchantUid());
        PaymentInfo paymentInfo =  paymentConnector.requestPaymentInfo(merchantUid);
        Payment payment = findPayment(merchantUid);
        payment.complete(paymentInfo);
        return new PaymentCompleteResponse(payment.getAmount());
    }



    public PaymentReadyResponse readyPayment(int uid, int amount)
    {
        User user = userService.findUser(uid);
        Payment payment = new Payment(amount);
        user.addPayment(payment);
        Payment savedPayment = paymentRepository.save(payment);
        return new PaymentReadyResponse(savedPayment);
    }

    private Payment findPayment(String merchantUid) {
        return findPayment(UUID.fromString(merchantUid));
    }

    private Payment findPayment(UUID merchantUid) {
        return paymentRepository.findByMerchantUid(merchantUid).orElseThrow(InvalidMerchantUidException::new);
    }
}
