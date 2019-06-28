package com.cskaoyan14th.xueyu;

import com.cskaoyan14th.bean.Device;
import com.cskaoyan14th.bean.DeviceShow;
import com.cskaoyan14th.bean.DeviceType;
import com.cskaoyan14th.bean.DeviceTypeExample;
import com.cskaoyan14th.mapper.DeviceMapper;
import com.cskaoyan14th.mapper.DeviceTypeMapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application.xml")
public class Mytest {
    @Autowired
    DeviceTypeMapper deviceTypeMapper;

    @Autowired
    DeviceMapper deviceMapper;

    @Test
    public void mytest1(){
        DeviceTypeExample deviceTypeExample = new DeviceTypeExample();
        DeviceTypeExample.Criteria criteria = deviceTypeExample.createCriteria();
        criteria.andDeviceTypeIdEqualTo("01");
        List<DeviceType> list = deviceTypeMapper.selectByExample(deviceTypeExample);
        System.out.println(list);
    }

    @Test
    public void mytest2(){
        List<DeviceShow> deviceShows = deviceMapper.selectDeviceShowBySingleConditionLike("deviceId", "%0%");
        System.out.println(deviceShows);
    }

    @Test
    public void mytest3(){
        Device device = new Device();
        device.setDeviceId("007");
        device.setDeviceTypeId("07");
        int insert = deviceMapper.insert(device);
    }
}