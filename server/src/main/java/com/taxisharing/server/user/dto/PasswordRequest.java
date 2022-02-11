package com.taxisharing.server.user.dto;

import com.taxisharing.server.auth.util.PasswordEncoder;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PasswordRequest {

    @NotBlank
    @Length(min = 8, max = 13)
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]+$")
    private String password;

    public PasswordRequest(String password)
    {
        this.password = password;
    }

    public String toHash()
    {
        PasswordEncoder passwordEncoder = new PasswordEncoder();
        return passwordEncoder.encode(this.password);
    }
}
