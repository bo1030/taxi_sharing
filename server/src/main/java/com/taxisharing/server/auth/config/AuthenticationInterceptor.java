package com.taxisharing.server.auth.config;

import com.taxisharing.server.auth.service.AuthenticationService;
import com.taxisharing.server.auth.util.AuthorizationExtractor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
@RequiredArgsConstructor
public class AuthenticationInterceptor implements HandlerInterceptor {

    private final AuthenticationService authenticationService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        if ("OPTIONS".equals(request.getMethod())) {
            return true;
        }

        String token = AuthorizationExtractor.extract(request);
        authenticationService.validateToken(token);
        request.setAttribute("uid",authenticationService.getBasicUserByToken(token).getId());
        return true;
    }
}