package com.example.demo.service.impl;

import com.example.demo.entity.DeptEntity;
import com.example.demo.entity.UserEntity;
import com.example.demo.mapper.DeptDaoMapper;
import com.example.demo.mapper.UserDaoMapper;
import com.example.demo.service.DeptService;
import com.example.demo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    public static final Logger logger = LoggerFactory.getLogger(DeptServiceImpl.class);
    @Autowired
    private DeptDaoMapper deptDaoMapper;

    @Override
    public List<DeptEntity> getAll() {
        List<DeptEntity> list = deptDaoMapper.getAll();
        System.out.println(list);
        return list;
    }

}
