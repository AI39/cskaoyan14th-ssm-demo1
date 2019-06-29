package com.cskaoyan14th.test.liwenjing;

import com.cskaoyan14th.bean.Technology;
import com.cskaoyan14th.bean.TechnologyExample;
import com.cskaoyan14th.bean.TechnologyRequirement;
import com.cskaoyan14th.mapper.TechnologyMapper;
import com.cskaoyan14th.mapper.TechnologyRequirementMapper;
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
    TechnologyRequirementMapper technologyRequirementMapper;
    @Test
    public void mytest(){


    }
}


