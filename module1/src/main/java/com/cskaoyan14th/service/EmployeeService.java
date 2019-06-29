package com.cskaoyan14th.service;

import com.cskaoyan14th.bean.Employee;
import com.cskaoyan14th.vo.Vo;
;import java.util.List;

public interface EmployeeService {
    Vo<Employee> queryEmployment(int page, int rows);

    int insertEmployee(Employee employee);

    int updateEmployee(Employee employee);

    int deleteEmployee(String[] ids);

    Employee queryEmploymentByEmpId(String empId);

    List<Employee> queryMember();

    Vo<Employee> queryByDepartmentName(String value, int page, int rows);

    Vo<Employee> searchByEmpId(String searchValue, int page, int rows);

    Vo<Employee> searchByEmpName(String searchValue, int page, int rows);
}
