package com.cskaoyan14th.xueyu;

import com.cskaoyan14th.bean.DeviceType;
import com.cskaoyan14th.bean.DeviceTypeExample;
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

    @Test
    public void mytest1(){
        DeviceTypeExample deviceTypeExample = new DeviceTypeExample();
        DeviceTypeExample.Criteria criteria = deviceTypeExample.createCriteria();
        criteria.andDeviceTypeIdEqualTo("01");
        List<DeviceType> list = deviceTypeMapper.selectByExample(deviceTypeExample);
        System.out.println(list);
    }
}