package com.taxisharing.server.user.dto;

import com.taxisharing.server.user.domain.Ban;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserBanResponse {
    private List<Ban> banList;

    public UserBanResponse(List<Ban> banList)
    {
        this.banList = banList;
    }
}
