package com.example.demo;

import com.example.demo.service.JenkinsBuildService;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author miaoying
 * @date 4/2/18
 */
public class JenkinsDemo {

    public static void main(String[] args) {
        JenkinsBuildService jenkinsBuildService = new JenkinsBuildService();
        String jobName = "fe_wh5_beta";
        Map<String, String> map = new HashMap<>();
        map.put("job_current_name", "fe_wh5_beta");
        map.put("tomcat_instance_name", "h5_new");
        map.put("job_place", "wh5");
        map.put("war_name", "dist");
        map.put("deploy_type", "beta");
        map.put("package_way", "sudo-npm-run-buildx");
        map.put("deploy_branch", "202011201410-wh5-update");
        jenkinsBuildService.build(jobName, map);
    }
}