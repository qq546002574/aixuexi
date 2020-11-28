package com.example.demo.service;

import com.example.demo.entity.JenkinsEntity;

import java.util.Map;

public interface JenkinsDoService {

    public static String JENKINSURL = "https://jenkins.fksaas.com:443";

    public static String AUTHNAME = "hushuai";

    public static String TOKEN = "118e30089ddf0319ef78790d8796f75a4b";

    public void doJenkins(String jobName, Map<String, String> map);
}
