package com.taxisharing.server.auth.controller;

import com.taxisharing.server.auth.dto.LoginRequest;
import com.taxisharing.server.auth.dto.TokenResponse;
import com.taxisharing.server.auth.exception.InvalidIdOrPassword;
import com.taxisharing.server.auth.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/login")
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @PostMapping()
    ResponseEntity<TokenResponse> login(@Valid @RequestBody LoginRequest loginRequest, BindingResult result)
    {
        if(result.hasErrors())
        {
            throw new InvalidIdOrPassword();
        }
        return ResponseEntity.ok(loginService.login(loginRequest));
    }
}
