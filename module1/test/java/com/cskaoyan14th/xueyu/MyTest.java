package com.cskaoyan14th.xueyu;


import com.cskaoyan14th.bean.Device;
import com.cskaoyan14th.bean.DeviceType;
import com.cskaoyan14th.mapper.DeviceMapper;
import com.cskaoyan14th.mapper.DeviceTypeMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:application.xml")
public class MyTest {
    @Autowired
    DeviceTypeMapper deviceTypeMapper;

    @Test
    public void test1() {
        List<DeviceType> list = deviceTypeMapper.selectPageDeviceTypeList(30, 1);
        System.out.println(list);
    }
}
