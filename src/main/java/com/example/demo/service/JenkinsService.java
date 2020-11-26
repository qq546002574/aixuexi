package com.example.demo.service;

import com.example.demo.entity.JenkinsEntity;

import java.util.List;


public interface JenkinsService {
    public List<JenkinsEntity> getAll();

    public JenkinsEntity getById(Integer id);

    public int updateByObj(JenkinsEntity jenkinsEntity);

    public int addJenkins(JenkinsEntity jenkinsEntity);

    public int delJenkins(Integer id);
}
