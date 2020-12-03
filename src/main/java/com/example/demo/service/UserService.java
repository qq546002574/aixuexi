package com.example.demo.service;

import com.example.demo.entity.UserEntity;
import org.springframework.stereotype.Service;


public interface UserService {

    // 密码返回要去掉
    public UserEntity getById(Integer id);

    public UserEntity getByUserName(String username);

    public int updatePw(Integer id, String password);
}
