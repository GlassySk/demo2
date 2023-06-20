package com.example.demo2.service.impl;
import com.example.demo2.entity.User;
import com.example.demo2.dao.UserMapper;
import com.example.demo2.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceimpl implements UserService {
    @Resource
    private UserMapper userMapper;
    @Override
    public User getUserInfo(int id) {
        return userMapper.getUserInfo(id);
    }

    @Override
    public int deleteById(int id) {
        return userMapper.deleteById(id);
    }
    @Override
    public int Update(User user) {
        return userMapper.update(user);
    }
    @Override
    public User save(User user) {
        int save = userMapper.save(user);
        return user;
    }
    @Override
    public List<User> selectAll() {
        return userMapper.selectAll();
    }

    @Override
    public User k() {
        return userMapper.k();
    }
}