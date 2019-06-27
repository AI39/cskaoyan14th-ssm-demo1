package com.cskaoyan14th.service;

import com.cskaoyan14th.bean.*;
import com.cskaoyan14th.vo.Vo;

import java.util.List;

public interface DeviceService {
    Vo<DeviceType> getDeviceTypeVo(int page, int rows);
    Boolean deviceTypeIsExists(String deviceTypeId);

    int insertDeviceType(DeviceType deviceType);

    int updateDeviceType(DeviceType deviceType);

    int deleteDeviceTypeByIds(List<String> ids);

    Vo<DeviceType> searchDeviceTypeByDeviceTypeId(String searchValue, int page, int rows);

    Vo<DeviceType> searchDeviceTypeByDeviceTypeName(String searchValue, int page, int rows);

    List<Department> getDepartment();

    DeviceType getDeviceTypeById(String deviceTypeId);

    Employee getEmployeeById(String employeeId);

    Vo<DeviceShow> getDeviceShowVo(int page, int rows);

    List<DeviceType> getDeviceType();

    List<Employee> getEmployee();

    Boolean deviceIsExists(String deviceId);

    int insertDevice(Device device);
}
