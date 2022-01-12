package com.taxisharing.server.auth.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JWTProvider {

    @Value("${jwt.secreteKey}")
    String secreteKey;
}
