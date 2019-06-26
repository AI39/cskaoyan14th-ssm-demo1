package com.cskaoyan14th.service;

import com.cskaoyan14th.bean.DeviceType;
import com.github.pagehelper.PageInfo;

public interface DeviceService {
    Page<DeviceType> getDeviceTypePage(int page, int rows);
    PageInfo<DeviceType> getDeviceTypePageInfo(int page, int rows);

    Boolean deviceTypeIsExists(String deviceTypeId);

    int insertDeviceType(DeviceType deviceType);
}
