package com.dhagakart.controller;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dhagakart.entity.AuthToken;
import com.dhagakart.models.TokenResponse;
import com.dhagakart.repo.AuthTokenRepository;

@RestController
public class AuthController {

	@Autowired
	private AuthTokenRepository tokenRepo;

	@PostMapping("/generate-token")
	public ResponseEntity<TokenResponse> generateToken(@RequestParam(defaultValue = "1440") int ttlMin) {

		// 1. Generate random token
		String token = UUID.randomUUID().toString();

		// 2. Calculate expiration time
		LocalDateTime now = LocalDateTime.now();
		LocalDateTime expiresAt = now.plusMinutes(ttlMin);

		// 3. Save to database
		AuthToken authToken = new AuthToken(token, now, expiresAt);
		tokenRepo.save(authToken);
		TokenResponse tokenResponse = new TokenResponse(token, expiresAt);

		return new ResponseEntity<>(tokenResponse, HttpStatus.OK);
	}
}