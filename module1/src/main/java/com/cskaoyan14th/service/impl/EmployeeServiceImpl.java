package com.cskaoyan14th.service.impl;

import com.cskaoyan14th.bean.Employee;
import com.cskaoyan14th.mapper.EmployeeMapper;
import com.cskaoyan14th.service.EmployeeService;
import com.cskaoyan14th.vo.Vo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeMapper employeeMapper;
    @Override
    public Vo<Employee> queryEmployment(int page, int rows) {
        PageHelper.startPage(page,rows);
        //查询
        List<Employee> employees = employeeMapper.queryMember();

        PageInfo<Employee> pageInfo = new PageInfo<Employee>(employees);

        //封装成Json数据
        Vo<Employee> employeeList = new Vo<>(pageInfo.getTotal(),pageInfo.getList());

        return employeeList;
    }

    @Override
    public int insertEmployee(Employee employee) {
        int i = employeeMapper.insertEmployee(employee);
        return i;
    }

    @Override
    public int updateEmployee(Employee employee) {
        int i = employeeMapper.updateEmployee(employee);
        return i;
    }

    @Override
    public int deleteEmployee(int ids ) {
        int i = employeeMapper.deleteEmployee(ids);
        return i;
    }

    @Override
    public Employee queryEmploymentByEmpId(String empId) {
        int id = Integer.parseInt(empId);
        Employee employee = employeeMapper.queryEmployeeByEmpId(id);
        return employee;
    }
}
