package com.cskaoyan14th.test.wzg;

import com.cskaoyan14th.bean.COrder;
import com.cskaoyan14th.mapper.COrderMapper;
import com.cskaoyan14th.mapper.CustomMapper;
import com.cskaoyan14th.mapper.ProductMapper;
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
    @Autowired
    ProductMapper productMapper;
    @Autowired
    CustomMapper customMapper;
    @Test
    public void test(){
        List<COrder> cOrders = orderMapper.queryOrdersLeftCustomAndProduct();
        System.out.println(cOrders);
        System.out.println();
    }

    @Test
    public void test2(){
        //List<String> ids = productMapper.likeSelectIdsByProductName("子");
        //List<String> ids = customMapper.likeSelectIdsByCustomName("网易");
        List<COrder> cOrders = orderMapper.likeSelectById("2");
        //List<COrder> orderList = orderMapper.selectByCustomIds(ids);
        System.out.println(cOrders);
    }

}
