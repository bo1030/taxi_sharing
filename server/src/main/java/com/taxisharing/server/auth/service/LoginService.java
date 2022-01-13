package com.taxisharing.server.auth.service;

import com.taxisharing.server.auth.domain.LoginInfo;
import com.taxisharing.server.auth.dto.LoginRequest;
import com.taxisharing.server.auth.dto.TokenResponse;
import com.taxisharing.server.auth.exception.InvalidIdOrPassword;
import com.taxisharing.server.auth.repository.LoginRepository;
import com.taxisharing.server.auth.util.PasswordEncoder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class LoginService {

    private final LoginRepository loginRepository;
    private final AuthenticationService authenticationService;
    private final PasswordEncoder passwordEncoder;

    public TokenResponse login(LoginRequest loginRequest)
    {
        LoginInfo findLoginInfo =  loginRepository.findByUsername(loginRequest.getUsername()).orElseThrow(InvalidIdOrPassword::new);
        if(!(passwordEncoder.matches(loginRequest.getPassword(),findLoginInfo.getHash())))
        {
            throw new InvalidIdOrPassword();
        }
        return new TokenResponse(authenticationService.createToken(findLoginInfo));
    }
}
