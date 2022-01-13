package com.taxisharing.server.auth.service;

import com.taxisharing.server.auth.dto.LoginRequest;
import com.taxisharing.server.auth.dto.TokenResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class LoginService {

    public TokenResponse login(LoginRequest loginRequest)
    {
        return null;
    }
}
