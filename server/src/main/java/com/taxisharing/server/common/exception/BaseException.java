package com.taxisharing.server.common.exception;

import com.taxisharing.server.common.dto.ErrorResponse;
import lombok.Getter;

@Getter
public class BaseException extends RuntimeException{

    private final String errorcode;

    public BaseException(String errorcode, String message)
    {
        super(message);
        this.errorcode = errorcode;
    }

    public ErrorResponse toResponse()
    {
        return new ErrorResponse(getErrorcode(), getMessage());
    }
}
