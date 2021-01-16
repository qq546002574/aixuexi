package com.example.demo;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.stereotype.Component;

@Component
public class TestQuartz implements Job {
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        //获取任务名
        String taskName = context.getJobDetail().getKey().getName();
        //处理执行任务之后的业务
    }
}
