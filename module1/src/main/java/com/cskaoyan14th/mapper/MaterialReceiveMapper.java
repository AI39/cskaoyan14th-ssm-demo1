package com.cskaoyan14th.mapper;

import com.cskaoyan14th.bean.MaterialReceive;
import com.cskaoyan14th.bean.MaterialReceiveExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MaterialReceiveMapper {
    long countByExample(MaterialReceiveExample example);

    int deleteByExample(MaterialReceiveExample example);

    int deleteByPrimaryKey(String receiveId);

    int insert(MaterialReceive record);

    int insertSelective(MaterialReceive record);

    List<MaterialReceive> selectByExample(MaterialReceiveExample example);

    MaterialReceive selectByPrimaryKey(String receiveId);

    int updateByExampleSelective(@Param("record") MaterialReceive record, @Param("example") MaterialReceiveExample example);

    int updateByExample(@Param("record") MaterialReceive record, @Param("example") MaterialReceiveExample example);

    int updateByPrimaryKeySelective(MaterialReceive record);

    int updateByPrimaryKey(MaterialReceive record);

    /*上面是逆向工程自动生成的，下面是自己手动添加的*/

    List<MaterialReceive> selectMaterialReceive();

    List<MaterialReceive> selectMaterialReceiveByReceiveId(@Param("receiveid") String receiveid);

    List<MaterialReceive> selectMaterialReceiveByMaterialId(@Param("materialid") String materialid);

}