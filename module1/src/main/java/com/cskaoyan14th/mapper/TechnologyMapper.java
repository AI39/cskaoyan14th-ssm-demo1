package com.cskaoyan14th.mapper;

import com.cskaoyan14th.bean.Technology;
import com.cskaoyan14th.bean.TechnologyExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TechnologyMapper {
    long countByExample(TechnologyExample example);

    int deleteByExample(TechnologyExample example);

    int deleteByPrimaryKey(String technologyId);

    int insert(Technology record);

    int insertSelective(Technology record);

    List<Technology> selectByExample(TechnologyExample example);

    Technology selectByPrimaryKey(String technologyId);

    int updateByExampleSelective(@Param("record") Technology record, @Param("example") TechnologyExample example);

    int updateByExample(@Param("record") Technology record, @Param("example") TechnologyExample example);

    int updateByPrimaryKeySelective(Technology record);

    int updateByPrimaryKey(Technology record);

    /*上面是逆向工程自动生成的，下面是自己手动添加的*/

}