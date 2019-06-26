package com.cakaoyan.mytest;

import com.cskaoyan14th.bean.Material;
import com.cskaoyan14th.mapper.MaterialMapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application.xml")
public class MaterialTest {
    @Autowired
    MaterialMapper materialMapper;

    @Test
    public void mytest1(){
        int i = materialMapper.selectPageMaterialCount(5, 0);
        System.out.println(i);
        List<Material> materials = materialMapper.selectMaterialList(5, 0);
        System.out.println(materials);
    }
}
