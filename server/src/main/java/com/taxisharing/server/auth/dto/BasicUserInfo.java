package com.taxisharing.server.auth.dto;

import lombok.Getter;

@Getter
public class BasicUserInfo {
    private Long id;
    private String nickname;

    public BasicUserInfo(Long id, String nickname)
    {
        this.id = id;
        this.nickname = nickname;
    }
}
