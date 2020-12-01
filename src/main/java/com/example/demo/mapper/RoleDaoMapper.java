package com.example.demo.mapper;

import com.example.demo.entity.RoleEntity;
import com.example.demo.entity.UserEntity;
import com.example.demo.vo.RoleVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RoleDaoMapper {

    RoleEntity getById(Integer id);

    RoleEntity getByUserId(Integer userId);

    List<RoleEntity> getByRoleUser(RoleEntity roleEntity);
}
