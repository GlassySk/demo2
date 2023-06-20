package com.example.demo2.service;

import com.example.demo2.entity.User;

import java.util.List;

public interface UserService {

    User getUserInfo(int id);
    int deleteById(int id);

    int Update(User user);

    User save(User user);
    List<User> selectAll();
    User k();
}
