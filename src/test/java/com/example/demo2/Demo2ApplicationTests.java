package com.example.demo2;

import com.example.demo2.dao.MybtUser;
import org.junit.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Demo2ApplicationTests {
    @Autowired
    private MybtUser mybtUser;
    @Test
    void contextLoads() {
    }

}
