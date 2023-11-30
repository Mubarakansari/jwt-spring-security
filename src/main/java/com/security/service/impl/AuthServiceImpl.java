package com.security.service.impl;

import com.security.dto.SignIn;
import com.security.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final AuthenticationManager authenticationManager;
    private final UserServiceImpl userService;
    private final JWTServiceImpl jwtService;

    @Override
    public Object signIn(SignIn user) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUserName(), user.getPassword()));
        } catch (BadCredentialsException e) {
            e.printStackTrace();
            throw new BadCredentialsException("Username or password Incorrect");
        }
        UserDetails userDetails = userService.loadUserByUsername(user.getUserName());
        return jwtService.generateToken(userDetails.getUsername());
    }
}
