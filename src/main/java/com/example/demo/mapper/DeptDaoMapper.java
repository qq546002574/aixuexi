package com.example.demo.mapper;

import com.example.demo.entity.DeptEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DeptDaoMapper {

    List<DeptEntity> getAll();
}
