package com.taxisharing.server.auth.domain;

public interface LoginInfo {
    int getId();
    String getHash();
    String getNickname();
}
