package com.cskaoyan14th.bean;

import java.util.Date;

public class DeviceCheck {
    private String deviceCheckId;

    private String deviceId;

    private String deviceCheckEmpId;

    private Date deviceCheckDate;

    private String deviceCheckResult;

    private String deviceCheckFaultId;

    public String getDeviceCheckId() {
        return deviceCheckId;
    }

    public void setDeviceCheckId(String deviceCheckId) {
        this.deviceCheckId = deviceCheckId == null ? null : deviceCheckId.trim();
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId == null ? null : deviceId.trim();
    }

    public String getDeviceCheckEmpId() {
        return deviceCheckEmpId;
    }

    public void setDeviceCheckEmpId(String deviceCheckEmpId) {
        this.deviceCheckEmpId = deviceCheckEmpId == null ? null : deviceCheckEmpId.trim();
    }

    public Date getDeviceCheckDate() {
        return deviceCheckDate;
    }

    public void setDeviceCheckDate(Date deviceCheckDate) {
        this.deviceCheckDate = deviceCheckDate;
    }

    public String getDeviceCheckResult() {
        return deviceCheckResult;
    }

    public void setDeviceCheckResult(String deviceCheckResult) {
        this.deviceCheckResult = deviceCheckResult == null ? null : deviceCheckResult.trim();
    }

    public String getDeviceCheckFaultId() {
        return deviceCheckFaultId;
    }

    public void setDeviceCheckFaultId(String deviceCheckFaultId) {
        this.deviceCheckFaultId = deviceCheckFaultId == null ? null : deviceCheckFaultId.trim();
    }

    /*上面是逆向工程自动生成的，下面是自己手动添加的*/

}