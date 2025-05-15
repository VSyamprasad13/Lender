package com.lenderApp.lender.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.lenderApp.lender.entity.Token;
import com.lenderApp.lender.repository.TokenRepository;

@Service
public class TokenService {

	    @Autowired
	    private TokenRepository tokenRepository;

	    public void saveToken(Long mobile, String tokenValue) {
	        Token token = new Token();
	        token.setMobile(mobile);
	        token.setTokenValue(tokenValue);
	        token.setCreatedAt(LocalDateTime.now());
	        token.setExpiresAt(token.getCreatedAt().plusHours(48));
	        tokenRepository.save(token);
	    }

//	    public boolean isTokenValid(String tokenValue) {
//	        return tokenRepository.findByTokenValue(tokenValue)
//	                .filter(t -> t.getExpiresAt().isAfter(LocalDateTime.now()))
//	                .isPresent();
//	    }
	    
}
