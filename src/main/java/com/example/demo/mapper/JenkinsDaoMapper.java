package com.example.demo.mapper;

import com.example.demo.entity.JenkinsEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface JenkinsDaoMapper {

    List<JenkinsEntity> getAll();

    JenkinsEntity getById(Integer id);

    int updateByObj(JenkinsEntity jenkinsEntity);

    int insert(JenkinsEntity jenkinsEntity);

    int deleteById(Integer id);
}
