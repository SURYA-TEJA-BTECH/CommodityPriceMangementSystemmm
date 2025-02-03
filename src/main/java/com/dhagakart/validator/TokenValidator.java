package com.dhagakart.validator;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.dhagakart.exception.InvalidTokenException;
import com.dhagakart.repo.AuthTokenRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TokenValidator {
    
    private final AuthTokenRepository authTokenRepository;

    public void validateToken(String token) {
        if (token == null || token.isBlank()) {
            throw new InvalidTokenException("Missing authorization token");
        }
        
        authTokenRepository.findById(token)
            .filter(authToken -> LocalDateTime.now().isBefore(authToken.getExpiresAt()))
            .orElseThrow(() -> new InvalidTokenException("Invalid or expired token"));
    }
}
