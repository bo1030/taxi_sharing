package com.taxisharing.server.user.dto;

import com.taxisharing.server.auth.util.PasswordEncoder;
import com.taxisharing.server.user.domain.User;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SignUpRequest {
    @Email
    @NotBlank
    private String email;
    @NotBlank
    @Length(max = 45)
    @Pattern(regexp = "^[a-zA-Z0-9]+$")
    private String username;
    @NotBlank
    @Length(min = 2, max = 16)
    @Pattern(regexp = "^[가-힣a-zA-Z0-9]+$")
    private String nickname;
    @NotBlank
    @Length(min = 8, max = 13)
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]+$")
    private String password;

    public SignUpRequest(String email, String username, String nickname, String password) {
        this.email = email;
        this.username = username;
        this.nickname = nickname;
        this.password = password;
    }

    public User toUser() {
        PasswordEncoder passwordEncoder = new PasswordEncoder();
        return new User(nickname, username, passwordEncoder.encode(password) ,email);
    }
}
