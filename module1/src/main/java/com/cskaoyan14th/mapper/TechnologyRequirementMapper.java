package com.cskaoyan14th.mapper;

import com.cskaoyan14th.bean.TechnologyRequirement;
import com.cskaoyan14th.bean.TechnologyRequirement;
import com.cskaoyan14th.bean.TechnologyRequirementExample;
import com.cskaoyan14th.bean.TechnologyRequirementShow;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TechnologyRequirementMapper {
    long countByExample(TechnologyRequirementExample example);

    int deleteByExample(TechnologyRequirementExample example);

    int deleteByPrimaryKey(String technologyRequirementId);

    int insert(TechnologyRequirement record);

    int insertSelective(TechnologyRequirement record);

    List<TechnologyRequirement> selectByExample(TechnologyRequirementExample example);

    TechnologyRequirement selectByPrimaryKey(String technologyRequirementId);

    int updateByExampleSelective(@Param("record") TechnologyRequirement record, @Param("example") TechnologyRequirementExample example);

    int updateByExample(@Param("record") TechnologyRequirement record, @Param("example") TechnologyRequirementExample example);

    int updateByPrimaryKeySelective(TechnologyRequirement record);

    int updateByPrimaryKey(TechnologyRequirement record);

    List<TechnologyRequirementShow> selectTechnologyRequirementShow();

    List<TechnologyRequirement> selectTechnologyRequorementByName(@Param("technologyName") String technologyName);



    /*上面是逆向工程自动生成的，下面是自己手动添加的*/

}