package com.example.demo2.service.impl;
import com.example.demo2.common.ListResponseEntity;
import com.example.demo2.common.ResponseEntity;
import com.example.demo2.entity.User;
import com.example.demo2.dao.UserMapper;
import com.example.demo2.service.UserService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
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

    @Override
    public ResponseEntity<ListResponseEntity> userpage(int page, int size,String id) {
        ResponseEntity<ListResponseEntity> responseEntity = new ResponseEntity<>();
        PageHelper.startPage(page,size);
        List<User> users = userMapper.userpage(id);
        List<User> userList=users;

        String[] usersArray = new String[users.size()];
        for (int i = 0; i < users.size(); i++) {
            users.get(i).setAll1();
        }
        for (User user: users){
            System.out.println(user);
        }

//      Page<MadaochuEvent> MadaochuEventAll=(Page<MadaochuEvent>)madaochuEvents;
        ListResponseEntity<User> listResponse =new ListResponseEntity();
        listResponse.setList(users);
        responseEntity.setData(listResponse);
        return responseEntity;
    }
}