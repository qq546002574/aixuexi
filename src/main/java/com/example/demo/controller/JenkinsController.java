package com.example.demo.controller;


import com.example.demo.common.utils.DataResult;
import com.example.demo.entity.JenkinsEntity;
import com.example.demo.entity.JenkinsHisEntity;
import com.example.demo.entity.UserEntity;
import com.example.demo.service.JenkinsHisService;
import com.example.demo.service.JenkinsService;
import com.example.demo.vo.JenkinsVO;
import com.example.demo.vo.UserVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/jenkins")
public class JenkinsController {

    @Autowired
    private JenkinsService jenkinsService;

    @Autowired
    private JenkinsHisService jenkinsHisService;

    @RequestMapping(value = "/getAll", method = {RequestMethod.POST ,RequestMethod.GET })
    public DataResult getAll() {
        return DataResult.success(jenkinsService.getAll());
    }


    @RequestMapping(value = "/{id}/do", method = {RequestMethod.POST ,RequestMethod.GET })
    public DataResult doJenkins(@PathVariable Integer id) {
        System.out.println("id:" + id);
        JenkinsEntity jenkinsEntity = jenkinsService.doJenkins(id);
        return DataResult.success();
    }


    @RequestMapping(value = "/{id}/base", method = {RequestMethod.POST ,RequestMethod.GET })
    public DataResult getJenkinsBase(@PathVariable Integer id) {
        System.out.println("id:" + id);
        JenkinsEntity jenkinsEntity = jenkinsService.getById(id);
        return DataResult.success(jenkinsEntity);
    }

    @RequestMapping(value = "/updateBase", method = {RequestMethod.POST ,RequestMethod.GET })
    public DataResult updateBase(JenkinsVO jenkinsVO) {
        try {
            System.out.println("*****"+ jenkinsVO.getId());
            JenkinsEntity jenkinsEntity = new JenkinsEntity();
            BeanUtils.copyProperties(jenkinsVO, jenkinsEntity);
            int updateNum = jenkinsService.updateByObj(jenkinsEntity);
            if (updateNum > 0) {
                return DataResult.success("更新成功");
            } else  {
                return DataResult.fail("更新失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return DataResult.fail("请求错误");
        }
    }

    @RequestMapping(value = "/addJenkins", method = {RequestMethod.POST ,RequestMethod.GET })
    public DataResult addJenkins(JenkinsVO jenkinsVO) {
        try {
            JenkinsEntity jenkinsEntity = new JenkinsEntity();
            BeanUtils.copyProperties(jenkinsVO, jenkinsEntity);
            int insertNum = jenkinsService.addJenkins(jenkinsEntity);
            if (insertNum > 0) {
                return DataResult.success("新增成功");
            } else  {
                return DataResult.fail("新增失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return DataResult.fail("请求错误");
        }
    }

    @RequestMapping(value = "/{id}/delJenkins", method = {RequestMethod.POST ,RequestMethod.GET })
    public DataResult delJenkins(@PathVariable Integer id) {
        try {
            int delNum = jenkinsService.delJenkins(id);
            if (delNum > 0) {
                return DataResult.success("新增成功");
            } else  {
                return DataResult.fail("新增失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return DataResult.fail("请求错误");
        }
    }
}
