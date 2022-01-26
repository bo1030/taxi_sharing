package com.taxisharing.server.user.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class EvaluateMannerRequest {
    private int score;

    public EvaluateMannerRequest(int score)
    {
        this.score = score;
    }
}
