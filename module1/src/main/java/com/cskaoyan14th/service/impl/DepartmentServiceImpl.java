package com.cskaoyan14th.service.impl;

import com.cskaoyan14th.bean.Department;
import com.cskaoyan14th.mapper.DepartmentMapper;
import com.cskaoyan14th.service.DepartmentService;
import com.cskaoyan14th.vo.Vo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    DepartmentMapper departmentMapper;
    @Override
    public Vo<Department> queryDepartment(int page, int rows) {
        PageHelper.startPage(page,rows);
        //查询
        List<Department> listDepartment = departmentMapper.queryDepartment();

        PageInfo<Department> pageInfo = new PageInfo<>(listDepartment);
        //封装
        Vo<Department> departmentVo = new Vo<>(pageInfo.getTotal(), pageInfo.getList());
        return departmentVo;
    }
}
