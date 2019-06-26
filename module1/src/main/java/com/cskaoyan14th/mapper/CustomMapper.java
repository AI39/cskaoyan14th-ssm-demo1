package com.cskaoyan14th.mapper;

import com.cskaoyan14th.bean.Custom;
import com.cskaoyan14th.bean.CustomExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CustomMapper {
    long countByExample(CustomExample example);

    int deleteByExample(CustomExample example);

    int deleteByPrimaryKey(String customId);

    int insert(Custom record);

    int insertSelective(Custom record);

    List<Custom> selectByExample(CustomExample example);

    Custom selectByPrimaryKey(String customId);

    int updateByExampleSelective(@Param("record") Custom record, @Param("example") CustomExample example);

    int updateByExample(@Param("record") Custom record, @Param("example") CustomExample example);

    int updateByPrimaryKeySelective(Custom record);

    int updateByPrimaryKey(Custom record);

    /*上面是逆向工程自动生成的，下面是自己手动添加的*/

}