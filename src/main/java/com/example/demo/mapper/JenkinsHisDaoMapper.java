package com.example.demo.mapper;

import com.example.demo.entity.JenkinsHisEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface JenkinsHisDaoMapper {

    List<JenkinsHisEntity> getAll();

    JenkinsHisEntity getById(Integer id);

    int updateByObj(JenkinsHisEntity jenkinsHisEntity);

    int insert(JenkinsHisEntity jenkinsHisEntity);

    int deleteById(Integer id);
}
