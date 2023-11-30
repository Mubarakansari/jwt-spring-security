package com.security.service;

import org.springframework.security.core.userdetails.UserDetails;

public interface JWTService {
    String extractUserName(String token);

    String generateToken(String userName);

    boolean isTokenValid(String token, UserDetails userDetails);
}
