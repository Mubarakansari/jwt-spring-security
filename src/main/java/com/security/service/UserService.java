package com.security.service;

import com.security.entity.User;

import java.util.List;

public interface UserService {
    Object create(User user);

    List<User> fetchAll();
}
