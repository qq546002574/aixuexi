package com.example.demo.controller;

import com.example.demo.common.utils.DataResult;
import com.example.demo.entity.QuartzTask;
import com.example.demo.service.QuartzTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/quartz")
public class QuartzController {

    @Autowired
    private QuartzTaskService quartzTaskService;

    /**
     * 添加定时任务
     * */
    @RequestMapping(value = "/add", method = {RequestMethod.POST ,RequestMethod.GET })
    public DataResult addQtz(QuartzTask qt){

        try {
            //1.成功启动定时任务
            quartzTaskService.addQtz(qt);

            //2.封装QuartzTask,执行保存
            quartzTaskService.saveAddQtz(qt);

            return DataResult.success("添加成功");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return DataResult.fail("添加失败");

    }

    /**
     * 定时任务列表
     * */
    @RequestMapping(value = "/list",method = {RequestMethod.POST ,RequestMethod.GET })
    public DataResult listQtz(){

        try {
            //1.查询所有定时任务
            List<QuartzTask> list = quartzTaskService.listQtz();
            return DataResult.success(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return DataResult.fail("获取失败");

    }

    /**
     * 删除定时任务
     * */
    @RequestMapping(value = "/delete",method = {RequestMethod.POST ,RequestMethod.GET })
    public DataResult deleteQtz(QuartzTask qt){

        try {
            // 执行删除
            quartzTaskService.deleteQtz(qt);

            // 根据id删除定时任务列表数据
            quartzTaskService.deleteQtzTask(qt.getJobId());

            return DataResult.success("删除成功");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return DataResult.fail("删除失败");

    }

    /**
     * 中止定时任务
     * */
    @RequestMapping(value = "/pause",method = {RequestMethod.POST ,RequestMethod.GET })
    public DataResult pauseQtz(QuartzTask qt){

        try {
            // 执行中止
            quartzTaskService.pauseQtz(qt);
            quartzTaskService.updateByObj(qt);
            return DataResult.success("中止成功");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return DataResult.fail("中止失败");

    }

    /**
     * 恢复定时任务
     * */
    @RequestMapping(value = "/resume",method = {RequestMethod.POST ,RequestMethod.GET })
    public DataResult resumeQtz(QuartzTask qt){

        try {
            // 执行中止
            quartzTaskService.resumeQtz(qt);
            quartzTaskService.updateByObj(qt);
            return DataResult.success("恢复成功");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return DataResult.fail("恢复失败");

    }

    @RequestMapping(value = "/start",method = {RequestMethod.POST ,RequestMethod.GET })
    public DataResult startQtz(QuartzTask qt){

        try {
            // 执行中止
            quartzTaskService.startQtz(qt);
            return DataResult.success("恢复成功");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return DataResult.fail("恢复失败");

    }

    @RequestMapping(value = "/{jobId}/base", method = {RequestMethod.POST ,RequestMethod.GET })
    public DataResult getJenkinsBase(@PathVariable Integer jobId) {
        System.out.println("jobId:" + jobId);
        QuartzTask quartzTask = quartzTaskService.getByJobId(jobId);
        return DataResult.success(quartzTask);
    }
}
