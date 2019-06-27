package com.cskaoyan14th.service;

import com.cskaoyan14th.bean.Task;
import com.cskaoyan14th.vo.Vo;

public interface TaskService {
    Vo<Task> getTaskList(int page, int rows);
}
