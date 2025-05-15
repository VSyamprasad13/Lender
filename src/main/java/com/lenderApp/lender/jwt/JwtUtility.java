package com.lenderApp.lender.jwt;

import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lenderApp.lender.entity.Token;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtility {
	
	private final String SECRET_KEY = "secret_key";
	
	private Token token;

    public String generateToken(Long mobile, String role) {
         String tokenCreated = Jwts.builder()
                .setSubject(String.valueOf(mobile))
                .claim("role", role)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)) // 10 hours
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
         token=new Token();
         token.setMobile(mobile);
         token.setTokenValue(tokenCreated);
         token.setCreatedAt(LocalDateTime.now());
         token.setExpiresAt(token.getCreatedAt().plusHours(48));
         return tokenCreated;
    }

    public String extractMobile(String token) {
        return Jwts.parser().setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody().getSubject();
    }

    public boolean validateToken(String token, Long mobile) {
        return extractMobile(token).equals(mobile) && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
        return Jwts.parser().setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody().getExpiration().before(new Date());
    }
    
    public String extractRole(String token) {
        return Jwts.parser().setSigningKey(SECRET_KEY)
            .parseClaimsJws(token)
            .getBody()
            .get("role", String.class);
    }
}
