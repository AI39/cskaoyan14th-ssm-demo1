package com.cskaoyan14th.service.impl;

import com.cskaoyan14th.bean.Task;
import com.cskaoyan14th.mapper.TaskMapper;
import com.cskaoyan14th.service.TaskService;
import com.cskaoyan14th.vo.Vo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    TaskMapper taskMapper;

    @Override
    public Vo<Task> getTaskList(int page, int rows) {
        //设置要返回第几页以以及每页要显示的数据条数
        PageHelper.startPage(page, rows);
        //进行查询
        List<Task> taskList1 = taskMapper.multiSelectAll();
        //把查询结果封装成分页所需的列表
        PageInfo<Task> pageInfo = new PageInfo<Task>(taskList1);
        //封装成前端所需的数据格式
        Vo<Task> taskList = new Vo<Task>(pageInfo.getTotal(), pageInfo.getList());
        return taskList;
    }

    @Override
    public int insert(Task task) {
        return taskMapper.insert(task);
    }

    @Override
    public int updateByPrimaryKeySelective(Task task) {
        return taskMapper.updateByPrimaryKeySelective(task);
    }

    @Override
    public int deleteByIds(String[] ids) {
        return taskMapper.deleteByIds(ids);
    }

    @Override
    public Vo<Task> searchTaskListByTaskId(String searchValue, int page, int rows) {
        //设置要返回第几页以以及每页要显示的数据条数
        PageHelper.startPage(page, rows);
        //进行模糊查询
        List<Task> taskList1 = taskMapper.multiSelectByLikeTaskId(searchValue);
        //把查询结果封装成分页所需的列表
        PageInfo<Task> pageInfo = new PageInfo<Task>(taskList1);
        //封装成前端所需的数据格式
        Vo<Task> taskList = new Vo<Task>(pageInfo.getTotal(), pageInfo.getList());
        return taskList;
    }

    @Override
    public Vo<Task> searchTaskListByTaskWorkId(String searchValue, int page, int rows) {
        //设置要返回第几页以以及每页要显示的数据条数
        PageHelper.startPage(page, rows);
        //进行模糊查询
        List<Task> taskList1 = taskMapper.multiSelectByLikeTaskWorkId(searchValue);
        //把查询结果封装成分页所需的列表
        PageInfo<Task> pageInfo = new PageInfo<Task>(taskList1);
        //封装成前端所需的数据格式
        Vo<Task> taskList = new Vo<Task>(pageInfo.getTotal(), pageInfo.getList());
        return taskList;
    }

    @Override
    public Vo<Task> searchTaskListByTaskManufactureSn(String searchValue, int page, int rows) {
        //设置要返回第几页以以及每页要显示的数据条数
        PageHelper.startPage(page, rows);
        //进行模糊查询
        List<Task> taskList1 = taskMapper.multiSelectByLikeTaskManufactureSn(searchValue);
        //把查询结果封装成分页所需的列表
        PageInfo<Task> pageInfo = new PageInfo<Task>(taskList1);
        //封装成前端所需的数据格式
        Vo<Task> taskList = new Vo<Task>(pageInfo.getTotal(), pageInfo.getList());
        return taskList;
    }
}
