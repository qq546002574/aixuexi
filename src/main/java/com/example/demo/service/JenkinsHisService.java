package com.example.demo.service;

import com.example.demo.entity.JenkinsEntity;
import com.example.demo.entity.JenkinsHisEntity;

import java.util.List;


public interface JenkinsHisService {
    public List<JenkinsHisEntity> getAll();

    public JenkinsHisEntity getById(Integer id);

    public int updateByObj(JenkinsHisEntity jenkinsHisEntity);

    public int addJenkins(JenkinsHisEntity jenkinsHisEntity);

    public int delJenkins(Integer id);
}
