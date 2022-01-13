package com.taxisharing.server.auth.util;


import org.springframework.security.crypto.bcrypt.BCrypt;

import java.security.MessageDigest;

public class PasswordEncoder {

    public String encode(String rawPassword)
    {
        return BCrypt.hashpw(rawPassword,BCrypt.gensalt(10));
    }

    public boolean matches(String rawPassword, String encodedPassword)
    {
        return BCrypt.checkpw(rawPassword,encodedPassword);
    }
}
