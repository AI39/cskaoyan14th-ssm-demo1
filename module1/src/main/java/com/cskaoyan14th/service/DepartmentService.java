package com.cskaoyan14th.service;

import com.cskaoyan14th.bean.Department;
import com.cskaoyan14th.vo.Vo;

public interface DepartmentService {
    Vo<Department> queryDepartment(int page, int rows);
}
