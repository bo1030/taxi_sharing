package com.taxisharing.server.auth.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class LoginRequest {
    @NotBlank
    @Pattern(regexp = "^[가-힣a-zA-Z0-9]+$")
    private String username;

    @NotBlank
    @Pattern(regexp = "^[가-힣a-zA-Z0-9]+$")
    private String password;
}
