package com.cskaoyan14th.mapper;

import com.cskaoyan14th.bean.Department;
import com.cskaoyan14th.bean.DepartmentExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DepartmentMapper {
    long countByExample(DepartmentExample example);

    int deleteByExample(DepartmentExample example);

    int deleteByPrimaryKey(String departmentId);

    int insert(Department record);

    int insertSelective(Department record);

    List<Department> selectByExample(DepartmentExample example);

    Department selectByPrimaryKey(String departmentId);

    int updateByExampleSelective(@Param("record") Department record, @Param("example") DepartmentExample example);

    int updateByExample(@Param("record") Department record, @Param("example") DepartmentExample example);

    int updateByPrimaryKeySelective(Department record);

    int updateByPrimaryKey(Department record);

    /*上面是逆向工程自动生成的，下面是自己手动添加的*/

    Department queryDepartmentById();

    List<Department> queryDepartment();

    int insertDepartment(@Param("dep") Department department);

    int updateDeparment(@Param("dep") Department ids);

    int deleteDepartment(@Param("ids") String[] ids);

    List<Department> queryDepartmentByDid(@Param("sea")  String searchValue);

    List<Department> queryDepartmentByName(@Param("name")String searchValue);
}