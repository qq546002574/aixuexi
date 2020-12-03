package com.example.demo.service;

import com.example.demo.entity.RoleEntity;
import com.example.demo.entity.UserEntity;
import com.example.demo.vo.RoleVO;

import java.util.List;


public interface RoleService {
    public RoleEntity getById(Integer roleId);

    public RoleEntity getByUserId(Integer userId);

    public List<RoleEntity> getByRoleUser(RoleVO roleVO);
}
