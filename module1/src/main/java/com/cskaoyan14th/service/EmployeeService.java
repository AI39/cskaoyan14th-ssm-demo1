package com.cskaoyan14th.service;

import com.cskaoyan14th.bean.Employee;
import com.cskaoyan14th.vo.Vo;
;

public interface EmployeeService {
    Vo<Employee> queryEmployment(int page, int rows);

    int insertEmployee(Employee employee);

    int updateEmployee(Employee employee);

    int deleteEmployee(int ids);

    Employee queryEmploymentByEmpId(String empId);
}
