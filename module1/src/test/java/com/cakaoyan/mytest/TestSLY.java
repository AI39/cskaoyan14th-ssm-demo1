package com.cakaoyan.mytest;

import com.cskaoyan14th.bean.Employee;
import com.cskaoyan14th.mapper.EmployeeMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application.xml")
public class TestSLY {
    @Autowired
    EmployeeMapper mapper;

    @Test
    public void test1(){
        List<Employee> employees = mapper.queryMember();
        System.out.println(employees);
    }

    @Test
    public void test2(){
        Employee employee = new Employee();

    }
}
