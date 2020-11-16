package com.example.demo.service.impl;

import com.example.demo.entity.JenkinsEntity;
import com.example.demo.entity.UserEntity;
import com.example.demo.mapper.JenkinsDaoMapper;
import com.example.demo.service.JenkinsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JenkinsServiceImpl implements JenkinsService {

    @Autowired
    private JenkinsDaoMapper jenkinsDaoMapper;

    @Override
    public List<JenkinsEntity> getAll() {
        List <JenkinsEntity> jenkinsEntityList = jenkinsDaoMapper.getAll();
        System.out.println(jenkinsEntityList);
        return jenkinsEntityList;
    }
}
