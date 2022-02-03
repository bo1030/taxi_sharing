package com.taxisharing.server.user.dto;

import com.taxisharing.server.user.domain.Ban;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserBanRequest {
    @NotNull
    private int targetId;

    public UserBanRequest(int targetId)
    {
        this.targetId = targetId;
    }
}
