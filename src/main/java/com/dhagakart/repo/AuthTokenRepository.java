package com.dhagakart.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dhagakart.entity.AuthToken;

public interface AuthTokenRepository extends JpaRepository<AuthToken, String> {

}
