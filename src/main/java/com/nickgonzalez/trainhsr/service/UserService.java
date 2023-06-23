package com.nickgonzalez.trainhsr.service;

import com.nickgonzalez.trainhsr.entity.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User save(User user);
}
