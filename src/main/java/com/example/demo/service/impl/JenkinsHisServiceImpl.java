package com.example.demo.service.impl;

import com.example.demo.entity.JenkinsEntity;
import com.example.demo.entity.JenkinsHisEntity;
import com.example.demo.mapper.JenkinsDaoMapper;
import com.example.demo.mapper.JenkinsHisDaoMapper;
import com.example.demo.service.JenkinsDoService;
import com.example.demo.service.JenkinsHisService;
import com.example.demo.service.JenkinsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JenkinsHisServiceImpl implements JenkinsHisService {


    @Autowired
    private JenkinsHisDaoMapper jenkinsHisDaoMapper;

    @Override
    public List<JenkinsHisEntity> getAll() {
        List <JenkinsHisEntity> jenkinsHisEntityList = jenkinsHisDaoMapper.getAll();
        System.out.println(jenkinsHisEntityList);
        return jenkinsHisEntityList;
    }

    @Override
    public JenkinsHisEntity getById(Integer id) {
        JenkinsHisEntity jenkinsHisEntity = jenkinsHisDaoMapper.getById(id);
        return jenkinsHisEntity;
    }

    @Override
    public int updateByObj(JenkinsHisEntity jenkinsHisEntity) {
        int updateNum = jenkinsHisDaoMapper.updateByObj(jenkinsHisEntity);
        return updateNum;
    }

    @Override
    public int addJenkins(JenkinsHisEntity jenkinsHisEntity) {
        int insertNum = jenkinsHisDaoMapper.insert(jenkinsHisEntity);
        return insertNum;
    }

    @Override
    public int delJenkins(Integer id) {
        int delNum = jenkinsHisDaoMapper.deleteById(id);
        return delNum;
    }
}
