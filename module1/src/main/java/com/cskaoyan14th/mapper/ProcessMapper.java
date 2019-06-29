package com.cskaoyan14th.mapper;

import com.cskaoyan14th.bean.Process;
import com.cskaoyan14th.bean.ProcessExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProcessMapper {
    long countByExample(ProcessExample example);

    int deleteByExample(ProcessExample example);

    int deleteByPrimaryKey(String processId);

    int insert(Process record);

    int insertSelective(Process record);

    List<Process> selectByExample(ProcessExample example);

    Process selectByPrimaryKey(String processId);

    int updateByExampleSelective(@Param("record") Process record, @Param("example") ProcessExample example);

    int updateByExample(@Param("record") Process record, @Param("example") ProcessExample example);

    int updateByPrimaryKeySelective(Process record);

    int updateByPrimaryKey(Process record);

    /*上面是逆向工程自动生成的，下面是自己手动添加的*/




}