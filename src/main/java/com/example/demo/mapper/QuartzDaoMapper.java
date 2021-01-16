package com.example.demo.mapper;

import com.example.demo.entity.JenkinsEntity;
import com.example.demo.entity.QuartzTask;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface QuartzDaoMapper {
    void addQtz(QuartzTask qt);

    void saveAddQtz(QuartzTask qt);

    List<QuartzTask> listQtz();

    void deleteQtz(QuartzTask qt);

    void deleteQtzTask(Long jobId);

    void pauseQtz(QuartzTask qt);

    void resumeQtz(QuartzTask qt);

    void updateByObj(QuartzTask qt);

    QuartzTask getByJobId(Integer jobId);
}
