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
        PageHelper.startPage(page, rows);
        List<Task> taskList1 = taskMapper.multiSelectAll();
        PageInfo<Task> pageInfo = new PageInfo<Task>(taskList1);
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
}
