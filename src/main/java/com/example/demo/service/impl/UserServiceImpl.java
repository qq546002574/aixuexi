package com.example.demo.service.impl;

import com.example.demo.entity.UserEntity;
import com.example.demo.mapper.UserDaoMapper;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDaoMapper userMapper;

    @Override
    public UserEntity getById(Integer id) {
//        System.out.println(id);
        UserEntity userEntity = userMapper.getById(id);
        System.out.println(userEntity);
        return userEntity;
    }

    @Override
    public UserEntity getByUserName(String username) {
        UserEntity userEntity = userMapper.getByUserName(username);
        System.out.println(userEntity);
        return userEntity;
    }
}
