package com.cskaoyan14th.service.impl;

import com.cskaoyan14th.bean.DeviceType;
import com.cskaoyan14th.bean.DeviceTypeExample;
import com.cskaoyan14th.bean.Page;
import com.cskaoyan14th.mapper.DeviceTypeMapper;
import com.cskaoyan14th.service.DeviceService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceServiceImpl implements DeviceService {
    @Autowired
    DeviceTypeMapper deviceTypeMapper;

    @Override
    public Page<DeviceType> getDeviceTypePage(int page, int rows) {
        int limit = rows;
        int offset = (page-1)*rows;
        int total = deviceTypeMapper.selectPageDeviceTypeCount(limit, offset);
        List<DeviceType> rowsList = deviceTypeMapper.selectPageDeviceTypeList(limit, offset);
        Page<DeviceType> deviceTypePage = new Page<>();
        deviceTypePage.setTotal(total);
        deviceTypePage.setRows(rowsList);
        return deviceTypePage;
    }
    public PageInfo<DeviceType> getDeviceTypePageInfo(int page, int rows) {
        PageHelper.startPage(page, rows);
        DeviceTypeExample deviceTypeExample = new DeviceTypeExample();
        DeviceTypeExample.Criteria criteria = deviceTypeExample.createCriteria();
        criteria.andDeviceTypeIdIsNotNull();
        List<DeviceType> list = deviceTypeMapper.selectByExample(deviceTypeExample);
        PageInfo<DeviceType> pageInfo = new PageInfo<>(list);
        return pageInfo;
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
}
