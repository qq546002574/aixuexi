package com.example.demo.service;

import com.example.demo.entity.UserEntity;
import org.springframework.stereotype.Service;


public interface UserService {
    public UserEntity getById(Integer id);

    public UserEntity getByUserName(String username);
}
