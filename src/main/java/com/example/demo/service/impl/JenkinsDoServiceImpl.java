package com.example.demo.service.impl;

import com.example.demo.service.JenkinsDoService;
import com.offbytwo.jenkins.JenkinsServer;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.Map;

@Service
public class JenkinsDoServiceImpl implements JenkinsDoService {

    public void doJenkins(String jobName, Map<String, String> map) {
        try{
            JenkinsServer jenkins = new JenkinsServer(new URI(JENKINSURL), AUTHNAME, TOKEN);
            jenkins.getJob(jobName).build(map);
//            String consoleOutputText=jenkins.getJob(jobName).getLastBuild().details().getConsoleOutputText();// 获取最近一次构建的日志输出
//            System.out.println(consoleOutputText);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
