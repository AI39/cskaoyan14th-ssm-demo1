package com.cskaoyan14th.service.impl;

import com.cskaoyan14th.bean.*;
import com.cskaoyan14th.mapper.*;
import com.cskaoyan14th.service.DeviceService;
import com.cskaoyan14th.vo.Vo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DeviceServiceImpl implements DeviceService {
    @Autowired
    DeviceTypeMapper deviceTypeMapper;
    @Autowired
    DeviceMapper deviceMapper;
    @Autowired
    DeviceCheckMapper deviceCheckMapper;
    @Autowired
    DeviceFaultMapper deviceFaultMapper;
    @Autowired
    DeviceMaintainMapper deviceMaintainMapper;

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
    public int updateDevice(Device device) {
        int i = deviceMapper.updateByPrimaryKey(device);
        return i;
    }

    @Override
    public int deleteDeviceByIds(ArrayList<String> list) {
        DeviceExample deviceExample = new DeviceExample();
        DeviceExample.Criteria criteria = deviceExample.createCriteria();
        criteria.andDeviceIdIn(list);
        int i = deviceMapper.deleteByExample(deviceExample);
        return i;
    }

    @Override
    public Vo<DeviceShow> searchDeviceShowByDeviceId(String searchValue, int page, int rows) {
        PageHelper.startPage(page,rows);
        List<DeviceShow> list = deviceMapper.selectDeviceShowBySingleConditionLike("deviceId", "%" + searchValue + "%");

        PageInfo<DeviceShow> pageInfo = new PageInfo<>(list);

        Vo<DeviceShow> deviceShowVo = new Vo<>(pageInfo.getTotal(),pageInfo.getList());
        return deviceShowVo;
    }

    @Override
    public Vo<DeviceShow> searchDeviceShowByDeviceName(String searchValue, int page, int rows) {
        PageHelper.startPage(page,rows);
        List<DeviceShow> list = deviceMapper.selectDeviceShowBySingleConditionLike("deviceName", "%" + searchValue + "%");

        PageInfo<DeviceShow> pageInfo = new PageInfo<>(list);

        Vo<DeviceShow> deviceShowVo = new Vo<>(pageInfo.getTotal(),pageInfo.getList());
        return deviceShowVo;
    }

    @Override
    public Vo<DeviceShow> searchDeviceByDeviceTypeName(String searchValue, int page, int rows) {
        PageHelper.startPage(page,rows);
        List<DeviceShow> list = deviceMapper.selectDeviceShowBySingleConditionLike("deviceTypeName", "%" + searchValue + "%");

        PageInfo<DeviceShow> pageInfo = new PageInfo<>(list);

        Vo<DeviceShow> deviceShowVo = new Vo<>(pageInfo.getTotal(),pageInfo.getList());
        return deviceShowVo;
    }

    @Override
    public Vo<DeviceCheckShow> getDeviceCheckShowVo(int page, int rows) {
        PageHelper.startPage(page,rows);
        List<DeviceCheckShow> list = deviceCheckMapper.selectDeviceCheckShow();

        PageInfo<DeviceCheckShow> pageInfo = new PageInfo<>(list);

        Vo<DeviceCheckShow> deviceCheckShowVo = new Vo<>(pageInfo.getTotal(),pageInfo.getList());
        return deviceCheckShowVo;
    }

    @Override
    public Device getDeviceById(String deviceId) {
        Device device = deviceMapper.selectByPrimaryKey(deviceId);
        return device;
    }

    @Override
    public List<Device> getDevice() {
        DeviceExample deviceExample = new DeviceExample();
        DeviceExample.Criteria criteria = deviceExample.createCriteria();
        criteria.andDeviceIdIsNotNull();
        List<Device> list = deviceMapper.selectByExample(deviceExample);
        return list;
    }

    @Override
    public Boolean deviceCheckIsExists(String deviceCheckId) {
        DeviceCheckExample deviceCheckExample = new DeviceCheckExample();
        DeviceCheckExample.Criteria criteria = deviceCheckExample.createCriteria();
        criteria.andDeviceCheckIdEqualTo(deviceCheckId);
        List<DeviceCheck> list = deviceCheckMapper.selectByExample(deviceCheckExample);
        if(list != null && list.size() != 0) {
            return true;
        }
        return false;
    }

    @Override
    public int insertDeviceCheck(DeviceCheck deviceCheck) {
        int i = deviceCheckMapper.insert(deviceCheck);
        return i;
    }

    @Override
    public int updateDeviceCheck(DeviceCheck deviceCheck) {
        int i = deviceCheckMapper.updateByPrimaryKey(deviceCheck);
        return i;
    }

    @Override
    public int deleteDeviceCheckByIds(ArrayList<String> list) {
        DeviceCheckExample deviceCheckExample = new DeviceCheckExample();
        DeviceCheckExample.Criteria criteria = deviceCheckExample.createCriteria();
        criteria.andDeviceCheckIdIn(list);
        int i = deviceCheckMapper.deleteByExample(deviceCheckExample);
        return i;
    }

    @Override
    public Vo<DeviceCheckShow> searchDeviceCheckShowByDeviceCheckId(String searchValue, int page, int rows) {
        PageHelper.startPage(page,rows);
        List<DeviceCheckShow> list = deviceCheckMapper.selectDeviceCheckShowBySingleConditionLike("deviceCheckId", "%" + searchValue + "%");

        PageInfo<DeviceCheckShow> pageInfo = new PageInfo<>(list);

        Vo<DeviceCheckShow> deviceCheckShowVo = new Vo<>(pageInfo.getTotal(),pageInfo.getList());
        return deviceCheckShowVo;
    }

    @Override
    public Vo<DeviceCheckShow> searchDeviceCheckShowByDeviceName(String searchValue, int page, int rows) {
        PageHelper.startPage(page,rows);
        List<DeviceCheckShow> list = deviceCheckMapper.selectDeviceCheckShowBySingleConditionLike("deviceName", "%" + searchValue + "%");

        PageInfo<DeviceCheckShow> pageInfo = new PageInfo<>(list);

        Vo<DeviceCheckShow> deviceCheckShowVo = new Vo<>(pageInfo.getTotal(),pageInfo.getList());
        return deviceCheckShowVo;
    }

    @Override
    public Vo<DeviceFaultShow> getDeviceFaultShowVo(int page, int rows) {
        PageHelper.startPage(page,rows);
        List<DeviceFaultShow> list = deviceFaultMapper.selectDeviceFaultShow();

        PageInfo<DeviceFaultShow> pageInfo = new PageInfo<>(list);

        Vo<DeviceFaultShow> deviceFaultShowVo = new Vo<>(pageInfo.getTotal(),pageInfo.getList());
        return deviceFaultShowVo;
    }

    @Override
    public List<DeviceFaultShow> getDeviceFaultShow() {
        List<DeviceFaultShow> list = deviceFaultMapper.selectDeviceFaultShow();
        return list;
    }

    @Override
    public Boolean deviceFaultIsExists(String deviceFaultId) {
        DeviceFaultExample deviceFaultExample = new DeviceFaultExample();
        DeviceFaultExample.Criteria criteria = deviceFaultExample.createCriteria();
        criteria.andDeviceFaultIdEqualTo(deviceFaultId);
        List<DeviceFault> list = deviceFaultMapper.selectByExample(deviceFaultExample);
        if(list != null && list.size() != 0) {
            return true;
        }
        return false;
    }

    @Override
    public int insertDeviceFault(DeviceFault deviceFault) {
        int i = deviceFaultMapper.insert(deviceFault);
        return i;
    }

    @Override
    public int updateDeviceFault(DeviceFault deviceFault) {
        int i = deviceFaultMapper.updateByPrimaryKey(deviceFault);
        return i;
    }

    @Override
    public int updateDeviceNoteByDeviceId(Device device) {
        int i = deviceMapper.updateByPrimaryKeySelective(device);
        return i;
    }

    @Override
    public int updateDeviceCheckNoteByDeviceCheckId(DeviceCheck deviceCheck) {
        int i = deviceCheckMapper.updateByPrimaryKeySelective(deviceCheck);
        return i;
    }

    @Override
    public int updateDeviceFaultNoteByDeviceFaultId(DeviceFault deviceFault) {
        int i = deviceFaultMapper.updateByPrimaryKeySelective(deviceFault);
        return i;
    }

    @Override
    public int deleteDeviceFaultByIds(ArrayList<String> list) {
        DeviceFaultExample deviceFaultExample = new DeviceFaultExample();
        DeviceFaultExample.Criteria criteria = deviceFaultExample.createCriteria();
        criteria.andDeviceFaultIdIn(list);
        int i = deviceFaultMapper.deleteByExample(deviceFaultExample);
        return i;
    }

    @Override
    public Vo<DeviceFaultShow> searchDeviceFaultShowByDeviceFaultId(String searchValue, int page, int rows) {
        PageHelper.startPage(page,rows);
        List<DeviceFaultShow> list = deviceFaultMapper.selectDeviceFaultShowBySingleConditionLike("deviceFaultId", "%" + searchValue + "%");

        PageInfo<DeviceFaultShow> pageInfo = new PageInfo<>(list);

        Vo<DeviceFaultShow> deviceFaultShowVo = new Vo<>(pageInfo.getTotal(),pageInfo.getList());
        return deviceFaultShowVo;
    }

    @Override
    public Vo<DeviceFaultShow> searchDeviceFaultShowByDeviceName(String searchValue, int page, int rows) {
        PageHelper.startPage(page,rows);
        List<DeviceFaultShow> list = deviceFaultMapper.selectDeviceFaultShowBySingleConditionLike("deviceName", "%" + searchValue + "%");

        PageInfo<DeviceFaultShow> pageInfo = new PageInfo<>(list);

        Vo<DeviceFaultShow> deviceFaultShowVo = new Vo<>(pageInfo.getTotal(),pageInfo.getList());
        return deviceFaultShowVo;
    }

    @Override
    public Vo<DeviceMaintainShow> getDeviceMaintainShowVo(int page, int rows) {
        PageHelper.startPage(page,rows);
        List<DeviceMaintainShow> list = deviceMaintainMapper.selectDeviceMaintainShow();

        PageInfo<DeviceMaintainShow> pageInfo = new PageInfo<>(list);

        Vo<DeviceMaintainShow> deviceMaintainShowVo = new Vo<>(pageInfo.getTotal(),pageInfo.getList());
        return deviceMaintainShowVo;
    }

    @Override
    public DeviceFault getDeviceFaultById(String deviceFaultId) {
        DeviceFault deviceFault = deviceFaultMapper.selectByPrimaryKey(deviceFaultId);
        return deviceFault;
    }


    @Override
    public DeviceType getDeviceTypeById(String deviceTypeId) {
        DeviceType deviceType = deviceTypeMapper.selectByPrimaryKey(deviceTypeId);
        return deviceType;
    }

    @Override
    public Boolean deviceMaintainIsExists(String deviceMaintainId) {
        DeviceMaintainExample deviceMaintainExample = new DeviceMaintainExample();
        DeviceMaintainExample.Criteria criteria = deviceMaintainExample.createCriteria();
        criteria.andDeviceMaintainIdEqualTo(deviceMaintainId);
        List<DeviceMaintain> list = deviceMaintainMapper.selectByExample(deviceMaintainExample);
        if(list != null && list.size() != 0) {
            return true;
        }
        return false;
    }

    @Override
    public int insertDeviceMaintain(DeviceMaintain deviceMaintain) {
        int i = deviceMaintainMapper.insert(deviceMaintain);
        return i;
    }

    @Override
    public int updateDeviceMaintain(DeviceMaintain deviceMaintain) {
        int i = deviceMaintainMapper.updateByPrimaryKey(deviceMaintain);
        return i;
    }

    @Override
    public int updateDeviceMaintainNoteByDeviceMaintainId(DeviceMaintain deviceMaintain) {
        int i = deviceMaintainMapper.updateByPrimaryKeySelective(deviceMaintain);
        return i;
    }

    @Override
    public int deleteDeviceMaintainByIds(ArrayList<String> list) {
        DeviceMaintainExample deviceMaintainExample = new DeviceMaintainExample();
        DeviceMaintainExample.Criteria criteria = deviceMaintainExample.createCriteria();
        criteria.andDeviceMaintainIdIn(list);
        int i = deviceMaintainMapper.deleteByExample(deviceMaintainExample);
        return i;
    }

    @Override
    public Vo<DeviceMaintainShow> searchDeviceMaintainShowByDeviceMaintainId(String searchValue, int page, int rows) {
        PageHelper.startPage(page,rows);
        List<DeviceMaintainShow> list = deviceMaintainMapper.selectDeviceMaintainShowBySingleConditionLike("deviceMaintainId", "%" + searchValue + "%");

        PageInfo<DeviceMaintainShow> pageInfo = new PageInfo<>(list);

        Vo<DeviceMaintainShow> deviceMaintainShowVo = new Vo<>(pageInfo.getTotal(),pageInfo.getList());
        return deviceMaintainShowVo;
    }

    @Override
    public Vo<DeviceMaintainShow> searchDeviceMaintainShowByDeviceFaultId(String searchValue, int page, int rows) {
        PageHelper.startPage(page,rows);
        List<DeviceMaintainShow> list = deviceMaintainMapper.selectDeviceMaintainShowBySingleConditionLike("deviceFaultId", "%" + searchValue + "%");

        PageInfo<DeviceMaintainShow> pageInfo = new PageInfo<>(list);

        Vo<DeviceMaintainShow> deviceMaintainShowVo = new Vo<>(pageInfo.getTotal(),pageInfo.getList());
        return deviceMaintainShowVo;
    }
}
