package com.example.demo.service.impl;

import com.example.demo.entity.QuartzTask;
import com.example.demo.mapper.QuartzDaoMapper;
import com.example.demo.service.QuartzTaskService;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class QuartzTaskServiceImpl implements QuartzTaskService {

    @Autowired
    private QuartzDaoMapper quartzDaoMapper;

    @Autowired
    private Scheduler scheduler;

    @Override
    public void addQtz(QuartzTask qt) {

        try {
            // 1.创建一个JobDetail实例，指定Quartz
            String cla = qt.getJobClass();
            Class clazz = Class.forName(cla);
            JobDetail jobDetail = JobBuilder.newJob(clazz) // 任务执行类
                    .withIdentity(qt.getJobName(), qt.getJobGroup())// 任务名，任务组
                    .build();
            CronScheduleBuilder builder = CronScheduleBuilder.cronSchedule(qt.getCronExpr());

            // 2.创建Trigger(触发器)
            Trigger trigger = TriggerBuilder.newTrigger().withIdentity(qt.getTriggerName(), qt.getTriggerGroupName())
                    .startNow().withSchedule(builder).build();

            // 3.告诉调度器使用该触发器来安排作业
            scheduler.scheduleJob(jobDetail, trigger);

            // 4.启动
            if (!scheduler.isShutdown()) {
                scheduler.start();
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void saveAddQtz(QuartzTask qt) {

        qt.setJobStatus(1);
        qt.setStartTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss ").format(new Date()));

        quartzDaoMapper.saveAddQtz(qt);

    }

    @Override
    public List<QuartzTask> listQtz() {

        return quartzDaoMapper.listQtz();
    }

    @Override
    public void deleteQtz(QuartzTask qt) {

        try {
            // 停止触发器
            scheduler.pauseTrigger(TriggerKey.triggerKey(qt.getTriggerName(), qt.getTriggerGroupName()));
            // 移除触发器
            scheduler.unscheduleJob(TriggerKey.triggerKey(qt.getTriggerName(), qt.getTriggerGroupName()));
            // 删除任务
            scheduler.deleteJob(JobKey.jobKey(qt.getJobName(), qt.getJobGroup()));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteQtzTask(Long jobId) {

        quartzDaoMapper.deleteQtzTask(jobId);

    }

    @Override
    public void pauseQtz(QuartzTask qt) {

        try {
            scheduler.pauseJob(JobKey.jobKey(qt.getJobName(), qt.getJobGroup()));
        } catch (SchedulerException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void resumeQtz(QuartzTask qt) {

        try {
            scheduler.resumeJob(JobKey.jobKey(qt.getJobName(), qt.getJobGroup()));
        } catch (SchedulerException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void startQtz(QuartzTask qt) {
        try {
            // 1.创建一个JobDetail实例，指定Quartz
            String cla = qt.getJobClass();
            Class clazz = Class.forName(cla);
            JobDetail jobDetail = JobBuilder.newJob(clazz) // 任务执行类
                    .withIdentity(qt.getJobName(), qt.getJobGroup())// 任务名，任务组
                    .build();
            CronScheduleBuilder builder = CronScheduleBuilder.cronSchedule(qt.getCronExpr());

            // 2.创建Trigger(触发器)
            Trigger trigger = TriggerBuilder.newTrigger().withIdentity(qt.getTriggerName(), qt.getTriggerGroupName())
                    .startNow().withSchedule(builder).build();

            // 3.告诉调度器使用该触发器来安排作业
            scheduler.scheduleJob(jobDetail, trigger);

            // 4.启动
            if (!scheduler.isShutdown()) {
                scheduler.start();
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void updateByObj(QuartzTask qt){
        quartzDaoMapper.updateByObj(qt);
    }

    @Override
    public QuartzTask getByJobId(Integer jobId){
        return quartzDaoMapper.getByJobId(jobId);
    }

}
