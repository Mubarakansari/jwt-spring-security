package com.security.controller;

import com.security.entity.User;
import com.security.service.UserService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("userController")
@Slf4j
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "create")
    public ResponseEntity<?> create(@Valid @RequestBody User user) {
        log.info("Create call");
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.create(user));
    }

    @GetMapping("fetchAll")
    public ResponseEntity<?> fetchAll() {
        log.info("fetchAll call");
        return ResponseEntity.status(HttpStatus.OK).body(userService.fetchAll());
    }

    @GetMapping("user")
    public ResponseEntity<?> user() {
        log.info("fetchAll user call");
        return ResponseEntity.status(HttpStatus.OK).body("User");
    }
}
