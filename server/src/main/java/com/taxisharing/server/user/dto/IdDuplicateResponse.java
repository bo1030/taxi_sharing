package com.taxisharing.server.user.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class IdDuplicateResponse {
    private String result;

    public IdDuplicateResponse(String result)
    {
        this.result = result;
    }
}
