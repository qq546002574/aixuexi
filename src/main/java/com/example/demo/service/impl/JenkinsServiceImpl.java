package com.example.demo.service.impl;

import com.example.demo.entity.JenkinsEntity;
import com.example.demo.entity.JenkinsHisEntity;
import com.example.demo.mapper.JenkinsDaoMapper;
import com.example.demo.service.JenkinsDoService;
import com.example.demo.service.JenkinsHisService;
import com.example.demo.service.JenkinsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.beans.BeanUtils;
import org.springframework.transaction.annotation.Transactional;

import java.net.Inet4Address;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class JenkinsServiceImpl implements JenkinsService {

    @Autowired
    private JenkinsDaoMapper jenkinsDaoMapper;

    @Autowired
    private JenkinsDoService jenkinsDoService;

    @Autowired
    private JenkinsService jenkinsService;

    @Autowired
    private JenkinsHisService jenkinsHisService;

    @Override
    public List<JenkinsEntity> getAll() {
        List <JenkinsEntity> jenkinsEntityList = jenkinsDaoMapper.getAll();
        System.out.println(jenkinsEntityList);
        return jenkinsEntityList;
    }

    @Override
    public JenkinsEntity getById(Integer id) {
        JenkinsEntity jenkinsEntity = jenkinsDaoMapper.getById(id);
        return jenkinsEntity;
    }

    @Override
    public JenkinsEntity doJenkins(Integer id) {
        JenkinsEntity jenkinsEntity = jenkinsDaoMapper.getById(id);
        String jobName = jenkinsEntity.getJobCurrentName();
        Map<String, String> map = new HashMap<>();
        map.put("job_current_name", jobName);
        map.put("tomcat_instance_name", jenkinsEntity.getTomcatInstanceName());
        map.put("job_place", jenkinsEntity.getJobPlace());
        map.put("war_name", jenkinsEntity.getWarName());
        map.put("deploy_type", jenkinsEntity.getDeployType());
        map.put("package_way", jenkinsEntity.getPackageWay());
        map.put("deploy_branch", jenkinsEntity.getDeployBranch());
        jenkinsDoService.doJenkins(jobName, map);
//        System.out.println(body);
        return jenkinsEntity;
    }

    @Override
    public int updateByObj(JenkinsEntity jenkinsEntity) {
        int updateNum = jenkinsDaoMapper.updateByObj(jenkinsEntity);
        return updateNum;
    }

    @Override
    public int addJenkins(JenkinsEntity jenkinsEntity) {
        int insertNum = jenkinsDaoMapper.insert(jenkinsEntity);
        return insertNum;
    }

    @Override
    @Transactional
    public int delJenkins(Integer id) {
        JenkinsEntity jenkinsEntity = jenkinsService.getById(id);
        JenkinsHisEntity jenkinsHisEntity = new JenkinsHisEntity();
        BeanUtils.copyProperties(jenkinsEntity, jenkinsHisEntity);
        Date cal = new Date();
        String date = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(cal.getTime());
        jenkinsHisEntity.setHistoryTime(date);
        int hisNumAdd = jenkinsHisService.addJenkins(jenkinsHisEntity);
        int delNum = 0;
        if (hisNumAdd > 0) {
            delNum = jenkinsDaoMapper.deleteById(id);
        }
        return delNum;
    }
}
