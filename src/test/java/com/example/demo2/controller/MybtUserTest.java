package com.example.demo2.controller;

import com.example.demo2.dao.MybtUser;
import com.example.demo2.service.impl.MybitUserSerimpl;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MybtUserTest {
    @Autowired
    MybitUserSerimpl mybitUserSerimpl;
    @Test
    public void queryAll()
    {
        mybitUserSerimpl.queryAll().forEach(System.out::println);
    }
}
