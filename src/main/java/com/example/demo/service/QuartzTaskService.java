package com.example.demo.service;

import com.example.demo.entity.QuartzTask;

import java.util.List;

public interface QuartzTaskService {
    void addQtz(QuartzTask qt);

    void saveAddQtz(QuartzTask qt);

    List<QuartzTask> listQtz();

    void deleteQtz(QuartzTask qt);

    void startQtz(QuartzTask qt);

    void deleteQtzTask(Long jobId);

    void pauseQtz(QuartzTask qt);

    void resumeQtz(QuartzTask qt);

    void updateByObj(QuartzTask qt);

    QuartzTask getByJobId(Integer jobId);
}
