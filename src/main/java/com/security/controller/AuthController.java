package com.security.controller;

import com.security.dto.SignIn;
import com.security.entity.User;
import com.security.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("authController")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping(value = "sign-in")
    public ResponseEntity<?> signIn(@Valid @RequestBody SignIn user) {
        log.info("signIn call");
        return ResponseEntity.status(HttpStatus.CREATED).body(authService.signIn(user));
    }
}
