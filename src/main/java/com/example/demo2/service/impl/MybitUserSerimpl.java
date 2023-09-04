package com.example.demo2.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo2.dao.MybtUser;
import com.example.demo2.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MybitUserSerimpl{
    @Autowired
    MybtUser mybtUser;
    public List<User> queryAll() {
        return mybtUser.selectList(null);
    }
}
