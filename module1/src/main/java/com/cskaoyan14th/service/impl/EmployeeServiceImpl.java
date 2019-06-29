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

    /**
     * 查询employee并封装分页
     * @param page
     * @param rows
     * @return
     */
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

    /**
     * 插入功能
     * @param employee
     * @return
     */
    @Override
    public int insertEmployee(Employee employee) {
        Employee employee1 = employeeMapper.selectByPrimaryKey(employee.getEmpId());
        if (employee1 == null){
            int i = employeeMapper.insertEmployee(employee);
            return i;
        }
        return -1;
    }

    /**
     * 更新功能
     * @param employee
     * @return
     */
    @Override
    public int updateEmployee(Employee employee) {
        int i = employeeMapper.updateEmployee(employee);
        return i;
    }

    /**
     * 删除功能
     * @param ids
     * @return
     */
    @Override
    public int deleteEmployee(String[] ids ) {
        int i = employeeMapper.deleteEmployee(ids);
        return i;
    }

    /**
     * 单人查询功能
     * @param empId
     * @return
     */
    @Override
    public Employee queryEmploymentByEmpId(String empId) {
        int id = Integer.parseInt(empId);
        Employee employee = employeeMapper.queryEmployeeByEmpId(id);
        return employee;
    }

    /**
     * 查询人员列表功能
     * @return
     */
    @Override
    public List<Employee> queryMember() {
        List<Employee> employeeList = employeeMapper.queryMember();
        return employeeList;
    }

    /**
     * 根据DepartmentName查询
     * @param value
     * @param page
     * @param rows
     * @return
     */
    @Override
    public Vo<Employee> queryByDepartmentName(String value, int page, int rows) {
        PageHelper.startPage(page,rows);
        //查询
        List<Employee> employees = employeeMapper.queryByDepartmentName(value);

        PageInfo<Employee> pageInfo = new PageInfo<Employee>(employees);

        //封装成Json数据
        Vo<Employee> employeeList = new Vo<>(pageInfo.getTotal(),pageInfo.getList());

        return employeeList;
    }

    /**
     * 根据empId查询
     * @param searchValue
     * @param page
     * @param rows
     * @return
     */
    @Override
    public Vo<Employee> searchByEmpId(String searchValue, int page, int rows) {
        PageHelper.startPage(page,rows);
        //查询
        List<Employee> employees = employeeMapper.searchByEmpId(searchValue);

        PageInfo<Employee> pageInfo = new PageInfo<Employee>(employees);

        //封装成Json数据
        Vo<Employee> employeeList = new Vo<>(pageInfo.getTotal(),pageInfo.getList());

        return employeeList;
    }

    /**
     * 根据empName查询
     * @param searchValue
     * @param page
     * @param rows
     * @return
     */
    @Override
    public Vo<Employee> searchByEmpName(String searchValue, int page, int rows) {

        PageHelper.startPage(page,rows);
        //查询
        List<Employee> employees = employeeMapper.searchByEmpName(searchValue);

        PageInfo<Employee> pageInfo = new PageInfo<Employee>(employees);

        //封装成Json数据
        Vo<Employee> employeeList = new Vo<>(pageInfo.getTotal(),pageInfo.getList());

        return employeeList;
    }
}
