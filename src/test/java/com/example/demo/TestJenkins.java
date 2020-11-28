package com.example.demo;

import com.offbytwo.jenkins.JenkinsServer;
import com.offbytwo.jenkins.model.Job;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

public class TestJenkins {

    public static void main(String[] args){
        try {
            // 创建JenkinsServer对象，第二个参数既可以密码也可以token
            String jobName = "fe_wh5_beta";
            Map<String, String> map = new HashMap<>();
            map.put("job_current_name", "fe_wh5_beta");
            map.put("tomcat_instance_name", "h5_new");
            map.put("job_place", "wh5");
            map.put("war_name", "dist");
            map.put("deploy_type", "beta");
            map.put("package_way", "sudo-npm-run-buildx");
            map.put("deploy_branch", "master");
            JenkinsServer jenkins = new JenkinsServer(new URI("https://jenkins.fksaas.com:443"), "hushuai", "118e30089ddf0319ef78790d8796f75a4b");
//            Map<String, Job> jobs = jenkins.getJobs(); //获取全部工作
//            jenkins.createJob("pipeline_3", jobXml);// 创建工作，jobXml是jenkins内的xml模板
//            jenkins.updateJob("pipeline_3", jobXml);// 更新工作
//            jenkins.deleteJob("pipeline_3");// 删除工作

            jenkins.getJob(jobName).build(map);// 启动构建
//            String consoleOutputText=jenkins.getJob(jobName).getLastBuild().details().getConsoleOutputText();// 获取最近一次构建的日志输出
//            System.out.println(consoleOutputText);
        } catch (Exception e) {

        }

    }
}
