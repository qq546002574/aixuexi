package com.example.demo.entity;

import lombok.Data;

@Data
public class QuartzTask {
    private Long jobId;

    private String jobClass; //任务类的全限定类名

    private String jobGroup; //任务组名

    private String jobName; //任务名

    private String triggerName; //任务触发器名

    private String triggerGroupName; //任务触发器组名

    private String cronExpr; //时间表达式

    private Integer jobStatus; //任务状态

    private String startTime; //任务开始时间

    private String description; //任务描述
}
