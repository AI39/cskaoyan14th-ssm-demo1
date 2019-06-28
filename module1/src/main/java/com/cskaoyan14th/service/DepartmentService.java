package com.cskaoyan14th.service;

import com.cskaoyan14th.bean.Department;
import com.cskaoyan14th.vo.Vo;

import java.util.List;

public interface DepartmentService {
    Vo<Department> queryDepartment(int page, int rows);

    List<Department> queryDepartmentAll();

    int insertDepartment(Department department);

    int updateDepartment(Department ids);

    int deleteDepartment(String[] ids);

    Vo<Department> searchDepartmentById(String searchValue, int page, int rows);

    Vo<Department> searchDepartmentByName(String searchValue, int page, int rows);
}
