package com.taxisharing.server.user.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class IdDuplicateRequest {
    @NotBlank
    @Length(max = 45)
    @Pattern(regexp = "^[a-zA-Z0-9]+$")
    private String username;

    public IdDuplicateRequest(String username)
    {
        this.username = username;
    }
}
