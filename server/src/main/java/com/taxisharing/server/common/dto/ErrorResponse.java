package com.taxisharing.server.common.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ErrorResponse {
    private String errorcode;
    private String message;

    public ErrorResponse(String errorcode, String message)
    {
        this.errorcode = errorcode;
        this.message = message;
    }
}
