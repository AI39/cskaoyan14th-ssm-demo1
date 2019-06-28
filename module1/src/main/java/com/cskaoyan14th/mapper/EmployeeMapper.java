package com.cskaoyan14th.mapper;

import com.cskaoyan14th.bean.Employee;
import com.cskaoyan14th.bean.EmployeeExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmployeeMapper {
    long countByExample(EmployeeExample example);

    int deleteByExample(EmployeeExample example);

    int deleteByPrimaryKey(String empId);

    int insert(Employee record);

    int insertSelective(Employee record);

    List<Employee> selectByExample(EmployeeExample example);

    Employee selectByPrimaryKey(String empId);

    int updateByExampleSelective(@Param("record") Employee record, @Param("example") EmployeeExample example);

    int updateByExample(@Param("record") Employee record, @Param("example") EmployeeExample example);

    int updateByPrimaryKeySelective(Employee record);

    int updateByPrimaryKey(Employee record);

    /*上面是逆向工程自动生成的，下面是自己手动添加的*/

    List<Employee> queryMember();

    int insertEmployee(@Param("emp")Employee employee);

    int updateEmployee(@Param("emp")Employee employee);

    int deleteEmployee(@Param("ids") String[] ids);

    Employee queryEmployeeByEmpId(@Param("empId")int empId);

    List<Employee> queryByDepartmentName(@Param("depName")String value);

    List<Employee> searchByEmpId(@Param("empId")String searchValue);

    List<Employee> searchByEmpName(@Param("empName")String searchValue);
}