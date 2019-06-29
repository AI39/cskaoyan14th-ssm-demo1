package com.cskaoyan14th.bean;

public class Process {
    private String processId;

    private String technologyPlanId;

    private Integer sequence;

    private Integer quota;

    public String getProcessId() {
        return processId;
    }

    public void setProcessId(String processId) {
        this.processId = processId == null ? null : processId.trim();
    }

    public String getTechnologyPlanId() {
        return technologyPlanId;
    }

    public void setTechnologyPlanId(String technologyPlanId) {
        this.technologyPlanId = technologyPlanId == null ? null : technologyPlanId.trim();
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    public Integer getQuota() {
        return quota;
    }

    public void setQuota(Integer quota) {
        this.quota = quota;
    }

    /*上面是逆向工程自动生成的，下面是自己手动添加的*/

    TechnologyPlan technologyPlan;

    public TechnologyPlan getTechnologyPlan() {
        return technologyPlan;
    }

    public void setTechnologyPlan(TechnologyPlan technologyPlan) {
        this.technologyPlan = technologyPlan;
    }

    @Override
    public String toString() {
        return "Process{" +
                "processId='" + processId + '\'' +
                ", technologyPlanId='" + technologyPlanId + '\'' +
                ", sequence=" + sequence +
                ", quota=" + quota +
                ", technologyPlan=" + technologyPlan +
                '}';
    }
}