package com.example.demo.service.impl;

import com.example.demo.entity.UserEntity;
import com.example.demo.mapper.UserDaoMapper;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    public static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
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

    @Override
    public int updatePw(Integer id, String password){
        int updateNum = userMapper.updatePw(id, password);
        logger.info("es client init...");
        return updateNum;
    }
}
