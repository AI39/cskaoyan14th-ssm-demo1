package com.cskaoyan14th.service.impl;

import com.cskaoyan14th.bean.*;
import com.cskaoyan14th.mapper.DepartmentMapper;
import com.cskaoyan14th.mapper.DeviceMapper;
import com.cskaoyan14th.mapper.DeviceTypeMapper;
import com.cskaoyan14th.mapper.EmployeeMapper;
import com.cskaoyan14th.service.DeviceService;
import com.cskaoyan14th.vo.Vo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceServiceImpl implements DeviceService {
    @Autowired
    DeviceTypeMapper deviceTypeMapper;
    @Autowired
    DeviceMapper deviceMapper;
    @Autowired
    DepartmentMapper departmentMapper;
    @Autowired
    EmployeeMapper employeeMapper;

    public Vo<DeviceType> getDeviceTypeVo(int page, int rows) {
        PageHelper.startPage(page,rows);

        DeviceTypeExample deviceTypeExample = new DeviceTypeExample();
        DeviceTypeExample.Criteria criteria = deviceTypeExample.createCriteria();
        criteria.andDeviceTypeIdIsNotNull();
        List<DeviceType> list = deviceTypeMapper.selectByExample(deviceTypeExample);

        PageInfo<DeviceType> pageInfo = new PageInfo<>(list);

        Vo<DeviceType> deviceTypeVo = new Vo<>(pageInfo.getTotal(),pageInfo.getList());
        return deviceTypeVo;
    }

    @Override
    public Boolean deviceTypeIsExists(String deviceTypeId) {
        DeviceTypeExample deviceTypeExample = new DeviceTypeExample();
        DeviceTypeExample.Criteria criteria = deviceTypeExample.createCriteria();
        criteria.andDeviceTypeIdEqualTo(deviceTypeId);
        List<DeviceType> list = deviceTypeMapper.selectByExample(deviceTypeExample);
        if(list != null && list.size() != 0) {
            return true;
        }
        return false;
    }

    @Override
    public int insertDeviceType(DeviceType deviceType) {
        int i = deviceTypeMapper.insert(deviceType);
        return i;
    }

    @Override
    public int updateDeviceType(DeviceType deviceType) {
        int i = deviceTypeMapper.updateByPrimaryKey(deviceType);
        return i;
    }

    @Override
    public int deleteDeviceTypeByIds(List<String> ids) {
        DeviceTypeExample deviceTypeExample = new DeviceTypeExample();
        DeviceTypeExample.Criteria criteria = deviceTypeExample.createCriteria();
        criteria.andDeviceTypeIdIn(ids);
        int i = deviceTypeMapper.deleteByExample(deviceTypeExample);
        return i;
    }

    @Override
    public Vo<DeviceType> searchDeviceTypeByDeviceTypeId(String searchValue, int page, int rows) {
        PageHelper.startPage(page,rows);

        DeviceTypeExample deviceTypeExample = new DeviceTypeExample();
        DeviceTypeExample.Criteria criteria = deviceTypeExample.createCriteria();
        criteria.andDeviceTypeIdLike("%" + searchValue + "%");
        List<DeviceType> list = deviceTypeMapper.selectByExample(deviceTypeExample);

        PageInfo<DeviceType> pageInfo = new PageInfo<>(list);

        Vo<DeviceType> deviceTypeVo = new Vo<>(pageInfo.getTotal(),pageInfo.getList());
        return deviceTypeVo;
    }

    @Override
    public Vo<DeviceType> searchDeviceTypeByDeviceTypeName(String searchValue, int page, int rows) {
        PageHelper.startPage(page,rows);

        DeviceTypeExample deviceTypeExample = new DeviceTypeExample();
        DeviceTypeExample.Criteria criteria = deviceTypeExample.createCriteria();
        criteria.andDeviceTypeNameLike("%" + searchValue + "%");
        List<DeviceType> list = deviceTypeMapper.selectByExample(deviceTypeExample);

        PageInfo<DeviceType> pageInfo = new PageInfo<>(list);

        Vo<DeviceType> deviceTypeVo = new Vo<>(pageInfo.getTotal(),pageInfo.getList());
        return deviceTypeVo;
    }

    @Override
    public Vo<DeviceShow> getDeviceShowVo(int page, int rows) {
        PageHelper.startPage(page,rows);
        List<DeviceShow> list = deviceMapper.selectDeviceShow();

        PageInfo<DeviceShow> pageInfo = new PageInfo<>(list);

        Vo<DeviceShow> deviceShowVo = new Vo<>(pageInfo.getTotal(),pageInfo.getList());
        return deviceShowVo;
    }

    @Override
    public List<DeviceType> getDeviceType() {
        DeviceTypeExample deviceTypeExample = new DeviceTypeExample();
        DeviceTypeExample.Criteria criteria = deviceTypeExample.createCriteria();
        criteria.andDeviceTypeIdIsNotNull();
        List<DeviceType> list = deviceTypeMapper.selectByExample(deviceTypeExample);
        return list;
    }

    @Override
    public List<Employee> getEmployee() {
        EmployeeExample employeeExample = new EmployeeExample();
        EmployeeExample.Criteria criteria = employeeExample.createCriteria();
        criteria.andEmpIdIsNotNull();
        List<Employee> list = employeeMapper.selectByExample(employeeExample);
        return list;
    }

    @Override
    public Boolean deviceIsExists(String deviceId) {
        DeviceExample deviceExample = new DeviceExample();
        DeviceExample.Criteria criteria = deviceExample.createCriteria();
        criteria.andDeviceIdEqualTo(deviceId);
        List<Device> list = deviceMapper.selectByExample(deviceExample);
        if(list != null && list.size() != 0) {
            return true;
        }
        return false;
    }

    @Override
    public int insertDevice(Device device) {
        int i = deviceMapper.insert(device);
        return i;
    }

    @Override
    public List<Department> getDepartment() {
        DepartmentExample departmentExample = new DepartmentExample();
        DepartmentExample.Criteria criteria = departmentExample.createCriteria();
        criteria.andDepartmentIdIsNotNull();
        List<Department> list = departmentMapper.selectByExample(departmentExample);
        return list;
    }

    @Override
    public DeviceType getDeviceTypeById(String deviceTypeId) {
        DeviceType deviceType = deviceTypeMapper.selectByPrimaryKey(deviceTypeId);
        return deviceType;
    }

    @Override
    public Employee getEmployeeById(String employeeId) {
        Employee employee = employeeMapper.selectByPrimaryKey(employeeId);
        return employee;
    }
}
