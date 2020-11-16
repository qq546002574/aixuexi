package com.example.demo.entity;

public class JenkinsEntity {
    private Integer id;
    private String jobCurrentName;
    private String tomcatInstanceName;
    private String jobPlace;
    private String warName;
    private String deployType;
    private String packageWay;
    private String deployBranch;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getJobCurrentName() {
        return jobCurrentName;
    }

    public void setJobCurrentName(String jobCurrentName) {
        this.jobCurrentName = jobCurrentName;
    }

    public String getTomcatInstanceName() {
        return tomcatInstanceName;
    }

    public void setTomcatInstanceName(String tomcatInstanceName) {
        this.tomcatInstanceName = tomcatInstanceName;
    }

    public String getJobPlace() {
        return jobPlace;
    }

    public void setJobPlace(String jobPlace) {
        this.jobPlace = jobPlace;
    }

    public String getWarName() {
        return warName;
    }

    public void setWarName(String warName) {
        this.warName = warName;
    }

    public String getDeployType() {
        return deployType;
    }

    public void setDeployType(String deployType) {
        this.deployType = deployType;
    }

    public String getPackageWay() {
        return packageWay;
    }

    public void setPackageWay(String packageWay) {
        this.packageWay = packageWay;
    }

    public String getDeployBranch() {
        return deployBranch;
    }

    public void setDeployBranch(String deployBranch) {
        this.deployBranch = deployBranch;
    }

    @Override
    public String toString() {
        return "JenkinsEntity{" +
                "id=" + id +
                ", jobCurrentName='" + jobCurrentName + '\'' +
                ", tomcatInstanceName='" + tomcatInstanceName + '\'' +
                ", jobPlace='" + jobPlace + '\'' +
                ", warName='" + warName + '\'' +
                ", deployType='" + deployType + '\'' +
                ", packageWay='" + packageWay + '\'' +
                ", deployBranch='" + deployBranch + '\'' +
                '}';
    }
}
