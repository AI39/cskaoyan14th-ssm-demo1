package com.cskaoyan14th.mapper;

import com.cskaoyan14th.bean.technologyRequirement;
import com.cskaoyan14th.bean.technologyRequirementExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface technologyRequirementMapper {
    long countByExample(technologyRequirementExample example);

    int deleteByExample(technologyRequirementExample example);

    int deleteByPrimaryKey(String technologyRequirementId);

    int insert(technologyRequirement record);

    int insertSelective(technologyRequirement record);

    List<technologyRequirement> selectByExample(technologyRequirementExample example);

    technologyRequirement selectByPrimaryKey(String technologyRequirementId);

    int updateByExampleSelective(@Param("record") technologyRequirement record, @Param("example") technologyRequirementExample example);

    int updateByExample(@Param("record") technologyRequirement record, @Param("example") technologyRequirementExample example);

    int updateByPrimaryKeySelective(technologyRequirement record);

    int updateByPrimaryKey(technologyRequirement record);

    /*上面是逆向工程自动生成的，下面是自己手动添加的*/

}