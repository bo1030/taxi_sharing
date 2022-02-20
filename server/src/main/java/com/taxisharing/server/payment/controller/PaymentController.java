package com.taxisharing.server.payment.controller;

import com.taxisharing.server.auth.dto.BasicUserInfo;
import com.taxisharing.server.payment.dto.PaymentCompleteRequest;
import com.taxisharing.server.payment.dto.PaymentCompleteResponse;
import com.taxisharing.server.payment.dto.PaymentReadyRequest;
import com.taxisharing.server.payment.dto.PaymentReadyResponse;
import com.taxisharing.server.payment.exception.PaymentCompleteException;
import com.taxisharing.server.payment.exception.PaymentReadyException;
import com.taxisharing.server.payment.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/payment")
@RequiredArgsConstructor
public class PaymentController {
    private final PaymentService paymentService;

    @PostMapping("/done")
    ResponseEntity<PaymentCompleteResponse> completePayment(BasicUserInfo basicUserInfo, @Valid @RequestBody PaymentCompleteRequest paymentCompleteRequest, BindingResult result)
    {
        if(result.hasErrors())
        {
            throw new PaymentCompleteException();
        }
        return ResponseEntity.ok(paymentService.completePayment(basicUserInfo.getId(), paymentCompleteRequest));
    }

    @PostMapping("/ready")
    ResponseEntity<PaymentReadyResponse> readyPayment(BasicUserInfo basicUserInfo, @Valid @RequestBody PaymentReadyRequest paymentReadyRequest, BindingResult result)
    {
        if(result.hasErrors())
        {
            throw new PaymentReadyException();
        }
        return ResponseEntity.ok(paymentService.readyPayment(basicUserInfo.getId(), paymentReadyRequest.getAmount()));
    }


}
