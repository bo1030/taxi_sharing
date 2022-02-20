package com.taxisharing.server.payment.dto;

import lombok.Data;

@Data
public class ResponseBody<T> {
    private String responseCode;
    private T response;
    private String message;
}
