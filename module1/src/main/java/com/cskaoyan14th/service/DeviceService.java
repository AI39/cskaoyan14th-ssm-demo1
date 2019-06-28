package com.cskaoyan14th.service;

import com.cskaoyan14th.bean.*;
import com.cskaoyan14th.vo.Vo;

import java.util.ArrayList;
import java.util.List;

public interface DeviceService {
    Vo<DeviceType> getDeviceTypeVo(int page, int rows);
    Boolean deviceTypeIsExists(String deviceTypeId);

    int insertDeviceType(DeviceType deviceType);

    int updateDeviceType(DeviceType deviceType);

    int deleteDeviceTypeByIds(List<String> ids);

    Vo<DeviceType> searchDeviceTypeByDeviceTypeId(String searchValue, int page, int rows);

    Vo<DeviceType> searchDeviceTypeByDeviceTypeName(String searchValue, int page, int rows);

    DeviceType getDeviceTypeById(String deviceTypeId);

    Vo<DeviceShow> getDeviceShowVo(int page, int rows);

    List<DeviceType> getDeviceType();

    Boolean deviceIsExists(String deviceId);

    int insertDevice(Device device);

    int updateDevice(Device device);

    int deleteDeviceByIds(ArrayList<String> list);

    Vo<DeviceShow> searchDeviceShowByDeviceId(String searchValue, int page, int rows);

    Vo<DeviceShow> searchDeviceShowByDeviceName(String searchValue, int page, int rows);

    Vo<DeviceShow> searchDeviceByDeviceTypeName(String searchValue, int page, int rows);
    
    Vo<DeviceCheckShow> getDeviceCheckShowVo(int page, int rows);

    Device getDeviceById(String deviceId);

    List<Device> getDevice();

    Boolean deviceCheckIsExists(String deviceCheckId);

    int insertDeviceCheck(DeviceCheck deviceCheck);

    int updateDeviceCheck(DeviceCheck deviceCheck);

    int deleteDeviceCheckByIds(ArrayList<String> list);

    Vo<DeviceCheckShow> searchDeviceCheckShowByDeviceCheckId(String searchValue, int page, int rows);

    Vo<DeviceCheckShow> searchDeviceCheckShowByDeviceName(String searchValue, int page, int rows);

    Vo<DeviceFaultShow> getDeviceFaultShowVo(int page, int rows);

    List<DeviceFaultShow> getDeviceFaultShow();
}
