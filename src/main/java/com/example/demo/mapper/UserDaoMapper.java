package com.example.demo.mapper;

import com.example.demo.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDaoMapper {

    UserEntity getById(Integer id);

    UserEntity getByUserName(String username);
}
