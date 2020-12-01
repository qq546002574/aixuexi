package com.example.demo.mapper;

import com.example.demo.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserDaoMapper {

    UserEntity getById(Integer id);

    UserEntity getByUserName(String username);

    int updatePw(@Param("id") Integer id, @Param("password") String password);
}
