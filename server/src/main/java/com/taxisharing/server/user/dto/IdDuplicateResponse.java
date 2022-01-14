package com.taxisharing.server.user.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class IdDuplicateResponse {
    private boolean result;

    public IdDuplicateResponse(boolean result)
    {
        this.result = result;
    }
}
