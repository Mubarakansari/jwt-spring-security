package com.security.service;

import com.security.dto.SignIn;
import com.security.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface AuthService {
    Object signIn(SignIn user);
}
