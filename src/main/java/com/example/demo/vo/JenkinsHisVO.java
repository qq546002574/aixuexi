package com.example.demo.vo;

import lombok.Data;

@Data
public class JenkinsHisVO {
    private Integer id;
    private String jobCurrentName;
    private String tomcatInstanceName;
    private String jobPlace;
    private String warName;
    private String deployType;
    private String packageWay;
    private String deployBranch;
}
