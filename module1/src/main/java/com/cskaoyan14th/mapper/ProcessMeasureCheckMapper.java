package com.cskaoyan14th.mapper;

import com.cskaoyan14th.bean.FinalCountCheckVo;
import com.cskaoyan14th.bean.ProcessMeasureCheck;
import com.cskaoyan14th.bean.ProcessMeasureCheckExample;
import com.cskaoyan14th.bean.ProcessMeasureCheckVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProcessMeasureCheckMapper {
    long countByExample(ProcessMeasureCheckExample example);

    int deleteByExample(ProcessMeasureCheckExample example);

    int deleteByPrimaryKey(String pMeasureCheckId);

    int insert(ProcessMeasureCheck record);

    int insertSelective(ProcessMeasureCheck record);

    List<ProcessMeasureCheck> selectByExample(ProcessMeasureCheckExample example);

    ProcessMeasureCheck selectByPrimaryKey(String pMeasureCheckId);

    int updateByExampleSelective(@Param("record") ProcessMeasureCheck record, @Param("example") ProcessMeasureCheckExample example);

    int updateByExample(@Param("record") ProcessMeasureCheck record, @Param("example") ProcessMeasureCheckExample example);

    int updateByPrimaryKeySelective(ProcessMeasureCheck record);

    int updateByPrimaryKey(ProcessMeasureCheck record);
    /*............................................................................*/

    List<ProcessMeasureCheck> queryProcessMeasureCheckLeftEmployee();
}