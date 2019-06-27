package com.cskaoyan14th.test.wzg;

import com.cskaoyan14th.bean.COrder;
import com.cskaoyan14th.mapper.COrderMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:application.xml")
public class OrderMapperTest {

    @Autowired
    COrderMapper orderMapper;

    @Test
    public void test(){
        List<COrder> cOrders = orderMapper.queryOrdersLeftCustomAndProduct();
        System.out.println(cOrders);
        System.out.println();
    }
}
