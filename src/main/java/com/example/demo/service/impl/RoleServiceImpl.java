package com.example.demo.service.impl;

import com.example.demo.entity.RoleEntity;
import com.example.demo.entity.UserEntity;
import com.example.demo.mapper.RoleDaoMapper;
import com.example.demo.mapper.UserDaoMapper;
import com.example.demo.service.RoleService;
import com.example.demo.vo.RoleVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDaoMapper roleDaoMapper;

    @Override
    public RoleEntity getById(Integer roleId) {
        RoleEntity roleEntity = roleDaoMapper.getById(roleId);
        System.out.println(roleEntity);
        return roleEntity;
    }

    @Override
    public RoleEntity getByUserId(Integer userId) {
        RoleEntity userEntity = roleDaoMapper.getByUserId(userId);
        System.out.println(userEntity);
        return userEntity;
    }

    @Override
    public List<RoleEntity> getByRoleUser(RoleVO roleVO){
        RoleEntity roleEntity = new RoleEntity();
        BeanUtils.copyProperties(roleVO, roleEntity);
        List <RoleEntity> list = roleDaoMapper.getByRoleUser(roleEntity);
        return list;
    }
}
