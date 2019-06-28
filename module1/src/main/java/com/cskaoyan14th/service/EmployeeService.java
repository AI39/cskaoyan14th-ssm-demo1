package com.cskaoyan14th.service;

import com.cskaoyan14th.bean.Employee;
import com.cskaoyan14th.vo.Vo;

public interface EmployeeService {
    Vo<Employee> queryEmployment(int page, int rows);
}
