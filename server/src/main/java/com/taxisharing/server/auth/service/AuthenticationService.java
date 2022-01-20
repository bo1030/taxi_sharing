package com.taxisharing.server.auth.service;

import com.taxisharing.server.auth.domain.LoginInfo;
import com.taxisharing.server.auth.util.JWTProvider;
import com.taxisharing.server.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final JWTProvider jwtProvider;

    public String createToken(LoginInfo loginInfo)
    {
        return jwtProvider.createToken(loginInfo.getId(),loginInfo.getNickname());
    }

    public String createToken(User user)
    {
        return jwtProvider.createToken(user.getId(),user.getNickname());
    }

}
