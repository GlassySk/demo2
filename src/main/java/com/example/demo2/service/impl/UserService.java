package com.example.demo2.service.impl;
import com.example.demo2.entity.User;
import com.example.demo2.mapper.UserMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
//list 无序集合  name USEr  Teacher
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public User getUserInfo(int id) {
        return userMapper.getUserInfo(id);
    }


    public int deleteById(int id) {
        return userMapper.deleteById(id);
    }

    public int Update(User user) {
        return userMapper.update(user);
    }

    public User save(User user) {
        int save = userMapper.save(user);
        return user;
    }

    public Page<User> selectAll(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<User> users1 = userMapper.selectAll();
        Page<User> users  = (Page<User>) users1;
        return  users;
    }
}