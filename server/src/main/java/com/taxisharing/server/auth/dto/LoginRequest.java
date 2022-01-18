package com.taxisharing.server.auth.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class LoginRequest {
    @NotBlank
    @Length(max = 45)
    @Pattern(regexp = "^[a-zA-Z0-9]+$")
    private String username;

    @NotBlank
    @Length(min = 8, max = 13)
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]$")
    private String password;
}
