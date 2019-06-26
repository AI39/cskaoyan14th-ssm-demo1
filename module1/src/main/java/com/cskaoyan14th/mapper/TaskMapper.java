package com.cskaoyan14th.mapper;

import com.cskaoyan14th.bean.Task;
import com.cskaoyan14th.bean.TaskExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TaskMapper {
    long countByExample(TaskExample example);

    int deleteByExample(TaskExample example);

    int deleteByPrimaryKey(String taskId);

    int insert(Task record);

    int insertSelective(Task record);

    List<Task> selectByExample(TaskExample example);

    Task selectByPrimaryKey(String taskId);

    int updateByExampleSelective(@Param("record") Task record, @Param("example") TaskExample example);

    int updateByExample(@Param("record") Task record, @Param("example") TaskExample example);

    int updateByPrimaryKeySelective(Task record);

    int updateByPrimaryKey(Task record);

    /*上面是逆向工程自动生成的，下面是自己手动添加的*/

}