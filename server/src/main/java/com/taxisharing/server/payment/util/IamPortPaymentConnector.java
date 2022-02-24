package com.taxisharing.server.payment.util;

import com.taxisharing.server.common.exception.BaseException;
import com.taxisharing.server.payment.dto.AccountInfo;
import com.taxisharing.server.payment.dto.ResponseBody;
import com.taxisharing.server.user.exception.AccountInvalidException;
import com.taxisharing.server.common.util.HttpConnector;
import com.taxisharing.server.payment.dto.PaymentInfo;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;

import java.util.UUID;

@Component
public class IamPortPaymentConnector implements PaymentConnector{

    private static final String IAMPORT_API_URL = "https://api.iamport.kr";

    @Value("iamport.key")
    private String impKey;

    @Value("iamport.secret")
    private String impSecret;

    @Override
    public PaymentInfo requestPaymentInfo(UUID merchantUid) {
        String accessToken = getAccessToken();

        return HttpConnector.send(
                IAMPORT_API_URL + "/payments/find/" + merchantUid,
                HttpMethod.POST,
                paymentInfoRequest(accessToken),
                new ParameterizedTypeReference<ResponseBody<PaymentInfo>>() {}
        ).getResponse();
    }

    private HttpEntity<Void> paymentInfoRequest(String accessToken)
    {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set(HttpHeaders.AUTHORIZATION, accessToken);

        return new HttpEntity<>(headers);
    }

    @Override
    public PaymentInfo requestPaymentRefund(UUID merchantUid) {
        String accessToken = getAccessToken();

        return HttpConnector.send(
                IAMPORT_API_URL + "/payments/cancel",
                HttpMethod.POST,
                paymentCancelRequest(accessToken, merchantUid),
                new ParameterizedTypeReference<ResponseBody<PaymentInfo>>() {}
        ).getResponse();
    }

    private HttpEntity<String> paymentCancelRequest(String accessToken, UUID merchantUid) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set(HttpHeaders.AUTHORIZATION, accessToken);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("merchant_uid", merchantUid);

        return new HttpEntity<>(jsonObject.toString(), headers);
    }

    @Override
    public String requestAccountHolder(String bankCode, String bankNum) {
        String accessToken = getAccessToken();
        AccountInfo accountInfo = accountHolderRequest(bankCode, bankNum, accessToken);

        return accountInfo.getBank_holder();
    }

    private AccountInfo accountHolderRequest(String bankCode, String bankNum, String accessToken) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set(HttpHeaders.AUTHORIZATION, accessToken);

        try {
            return HttpConnector.send(
                    IAMPORT_API_URL + "/vbanks/holder?bank_code=" + bankCode + "&" + "bank_num=" + bankNum,
                    HttpMethod.GET,
                    new HttpEntity<>(headers),
                    new ParameterizedTypeReference<ResponseBody<AccountInfo>>() {}
            ).getResponse();
        } catch (HttpClientErrorException e) {
            if (e.getStatusCode().equals(HttpStatus.NOT_FOUND)) {
                throw new AccountInvalidException();
            }
            int status = e.getRawStatusCode();
            throw new BaseException("error-002", "계좌인증API오류: " + status);
        }
    }


    private String getAccessToken()
    {
        String body = HttpConnector.send(
                IAMPORT_API_URL + "user/getToken",
                HttpMethod.POST,
                accessTokenRequest()
        );

        return new JSONObject(body).getJSONObject("response").getString("access_token");
    }

    private HttpEntity<String> accessTokenRequest()
    {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("imp_key", impKey);
        jsonObject.put("imp_secret", impSecret);

        return new HttpEntity<>(jsonObject.toString(), headers);
    }
}
