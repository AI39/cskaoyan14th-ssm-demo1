package com.cskaoyan14th.mapper;

import com.cskaoyan14th.bean.FinalCountCheck;
import com.cskaoyan14th.bean.FinalCountCheckExample;
import com.cskaoyan14th.bean.FinalCountCheckVo;
import com.cskaoyan14th.bean.FinalMeasuretCheckVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FinalCountCheckMapper {
    long countByExample(FinalCountCheckExample example);

    int deleteByExample(FinalCountCheckExample example);

    int deleteByPrimaryKey(String fCountCheckId);

    int insert(FinalCountCheck record);

    int insertSelective(FinalCountCheck record);

    List<FinalCountCheck> selectByExample(FinalCountCheckExample example);

    FinalCountCheck selectByPrimaryKey(String fCountCheckId);

    int updateByExampleSelective(@Param("record") FinalCountCheck record, @Param("example") FinalCountCheckExample example);

    int updateByExample(@Param("record") FinalCountCheck record, @Param("example") FinalCountCheckExample example);

    int updateByPrimaryKeySelective(FinalCountCheck record);

    int updateByPrimaryKey(FinalCountCheck record);

    /*上面是逆向工程自动生成的，下面是自己手动添加的*/
    List<FinalCountCheckVo> queryFinalCountCheckLeftEmployee();
}