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

    /**
     * 查询并封装Department
     * @param page
     * @param rows
     * @return
     */
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

    /**
     * 查询department
     * @return
     */
    @Override
    public List<Department> queryDepartmentAll() {

        List<Department> departmentList = departmentMapper.queryDepartment();

        return  departmentList;
    }

    /**
     * 插入
     * @param department
     * @return
     */
    @Override
    public int insertDepartment(Department department) {
        Department department1 = departmentMapper.selectByPrimaryKey(department.getDepartmentId());
        if (department1 == null){
            int i = departmentMapper.insertDepartment(department);
            return i;
        }
        return -1;
    }

    /**
     * 更新
     * @param ids
     * @return
     */
    @Override
    public int updateDepartment(Department ids) {

        int i = departmentMapper.updateDeparment(ids);

        return i;
    }

    /**
     * 删除
     * @param ids
     * @return
     */
    @Override
    public int deleteDepartment(String[] ids) {
        int i  = departmentMapper.deleteDepartment(ids);
        return i;
    }

    /**
     * 通过id查询
     * @param searchValue
     * @param page
     * @param rows
     * @return
     */
    @Override
    public Vo<Department> searchDepartmentById(String searchValue, int page, int rows) {
        PageHelper.startPage(page,rows);
        //查询
            List<Department> departmentList = departmentMapper.queryDepartmentByDid(searchValue);

        PageInfo<Department> pageInfo = new PageInfo(departmentList);

        //返回值
        Vo<Department> departmentServiceVo = new Vo<Department>(pageInfo.getTotal(), pageInfo.getList());

        return departmentServiceVo;
    }

    /**
     * 通过Name查询
     * @param searchValue
     * @param page
     * @param rows
     * @return
     */
    @Override
    public Vo<Department> searchDepartmentByName(String searchValue, int page, int rows) {

        PageHelper.startPage(page,rows);
        //查询
        List<Department> departmentList = departmentMapper.queryDepartmentByName(searchValue);

        PageInfo<Department> pageInfo = new PageInfo(departmentList);

        //返回值
        Vo<Department> departmentServiceVo = new Vo<Department>(pageInfo.getTotal(), pageInfo.getList());

        return departmentServiceVo;
    }

    @Override
    public int updateNoteDepartment(String departmentId, String note) {
        int i = departmentMapper.updateNoteDepartment(departmentId,note);
        return i;
    }

    @Override
    public Department queryDepartmentById(String depId) {

        Department department = departmentMapper.queryDepartmentById(depId);
        return department;
    }
}
