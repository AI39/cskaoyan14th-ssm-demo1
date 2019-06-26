package com.cskaoyan14th.mapper;

import com.cskaoyan14th.bean.Material;
import com.cskaoyan14th.bean.MaterialExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MaterialMapper {
    long countByExample(MaterialExample example);

    int deleteByExample(MaterialExample example);

    int deleteByPrimaryKey(String materialId);

    int insert(Material record);

    int insertSelective(Material record);

    List<Material> selectByExample(MaterialExample example);

    Material selectByPrimaryKey(String materialId);

    int updateByExampleSelective(@Param("record") Material record, @Param("example") MaterialExample example);

    int updateByExample(@Param("record") Material record, @Param("example") MaterialExample example);

    int updateByPrimaryKeySelective(Material record);

    int updateByPrimaryKey(Material record);

    /*上面是逆向工程自动生成的，下面是自己手动添加的*/

}