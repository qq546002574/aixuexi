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
import java.util.List;

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
//        String body = jenkinsDoService.doExchange(1,"123");
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
