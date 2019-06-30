package com.cskaoyan14th.bean;

import java.util.Date;

public class TechnologyRequirementShow {
    private String technologyRequirementId;

    private String technologyId;

    private String requirement;

    private Date addTime;

    private Date reviseTime;

    private String technologyName;

    public String getTechnologyRequirementId() {
        return technologyRequirementId;
    }

    public void setTechnologyRequirementId(String technologyRequirementId) {
        this.technologyRequirementId = technologyRequirementId;
    }

    public String getTechnologyId() {
        return technologyId;
    }

    public void setTechnologyId(String technologyId) {
        this.technologyId = technologyId;
    }

    public String getRequirement() {
        return requirement;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Date getReviseTime() {
        return reviseTime;
    }

    public void setReviseTime(Date reviseTime) {
        this.reviseTime = reviseTime;
    }

    public String getTechnologyName() {
        return technologyName;
    }

    public void setTechnologyName(String technologyName) {
        this.technologyName = technologyName;
    }

    public TechnologyRequirementShow(String technologyRequirementId, String technologyId, String requirement, Date addTime, Date reviseTime, String technologyName) {
        this.technologyRequirementId = technologyRequirementId;
        this.technologyId = technologyId;
        this.requirement = requirement;
        this.addTime = addTime;
        this.reviseTime = reviseTime;
        this.technologyName = technologyName;
    }

    public TechnologyRequirementShow() {
    }

    @Override
    public String toString() {
        return "TechnologyRequirementShow{" +
                "technologyRequirementId='" + technologyRequirementId + '\'' +
                ", technologyId='" + technologyId + '\'' +
                ", requirement='" + requirement + '\'' +
                ", addTime=" + addTime +
                ", reviseTime=" + reviseTime +
                ", technologyName='" + technologyName + '\'' +
                '}';
    }
}
