package com.taxisharing.server.user.service;

import com.taxisharing.server.auth.service.AuthenticationService;
import com.taxisharing.server.user.domain.User;
import com.taxisharing.server.user.dto.SignUpRequest;
import com.taxisharing.server.user.dto.SignUpResponse;
import com.taxisharing.server.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {
    public final UserRepository userRepository;
    public final AuthenticationService authenticationService;
    public SignUpResponse signUp(SignUpRequest signUpRequest)
    {
        User user = signUpRequest.toUser();
        User savedUser = userRepository.save(user);
        return new SignUpResponse(authenticationService.createToken(savedUser));
    }
}
