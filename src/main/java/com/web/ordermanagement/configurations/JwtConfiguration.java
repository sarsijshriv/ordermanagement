package com.web.ordermanagement.configurations;

import com.web.ordermanagement.misc.Constants;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtConfiguration {

    String secretKey = "";

    public JwtConfiguration()  {
        try {
            SecretKey sk = KeyGenerator.getInstance("HmacSHA256").generateKey();
            secretKey = Base64.getEncoder().encodeToString(sk.getEncoded());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public String generateToken(String userId){
        Map<String, Claims> claimsMap = new HashMap<>();
        return Jwts.builder()
                .claims(claimsMap)
                .subject(userId)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + Constants.JWT_TOKEN_EXPIRATION_TIME))
                .signWith(getKey())
                .compact();

    }

    private Key getKey() {
        return Keys.hmacShaKeyFor(secretKey.getBytes());
    }
}
