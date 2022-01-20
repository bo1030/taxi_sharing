package com.taxisharing.server.auth.dto;

import lombok.Getter;

@Getter
public class BasicUserInfo {
    private Integer id;
    private String nickname;

    public BasicUserInfo(Integer id, String nickname)
    {
        this.id = id;
        this.nickname = nickname;
    }
}
