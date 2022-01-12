package com.taxisharing.server.auth.util;

import com.taxisharing.server.auth.dto.BasicUserInfo;
import com.taxisharing.server.auth.exception.InvalidTokenException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

@Component
public class JWTProvider {

    @Value("${jwt.secreteKey}")
    String secreteKey;
    @Value("${jwt.expire-length}")
    private long validityInMilliseconds;

    public String createToken(long id, String email) {
        Date now = new Date();
        Date validity = new Date(now.getTime() + validityInMilliseconds);
        return Jwts.builder()
                .claim("id", id)
                .claim("email", email)
                .setIssuedAt(now)
                .setExpiration(validity)
                .signWith(SignatureAlgorithm.HS256, secreteKey)
                .compact();
    }

    public void validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(secreteKey).parseClaimsJws(token);
        } catch (JwtException | IllegalArgumentException e) {
            throw new InvalidTokenException();
        }
    }

    public BasicUserInfo findIdAndEmailFromToken(String token) {
        Claims claims = claims(token);
        return new BasicUserInfo(
                claims.get("id", Long.class),
                claims.get("email", String.class));
    }

    private Claims claims(String token) {
        try {
            return Jwts.parser()
                    .setSigningKey(secreteKey).parseClaimsJws(token)
                    .getBody();
        } catch (JwtException e) {
            throw new InvalidTokenException();
        }
    }
}
