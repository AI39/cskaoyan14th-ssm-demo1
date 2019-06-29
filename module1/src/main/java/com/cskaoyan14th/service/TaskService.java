package com.cskaoyan14th.service;

import com.cskaoyan14th.bean.Task;
import com.cskaoyan14th.vo.Vo;

public interface TaskService {
    Vo<Task> getTaskList(int page, int rows);

    int insert(Task task);

    int updateByPrimaryKeySelective(Task task);

    int deleteByIds(String[] ids);

    Vo<Task> searchTaskListByTaskId(String searchValue, int page, int rows);

    Vo<Task> searchTaskListByTaskWorkId(String searchValue, int page, int rows);

    Vo<Task> searchTaskListByTaskManufactureSn(String searchValue, int page, int rows);
}
