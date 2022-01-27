package com.taxisharing.server.user.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class EvaluateMannerResponse {
    private int result;

    public EvaluateMannerResponse(int result)
    {
        this.result = result;
    }
}
