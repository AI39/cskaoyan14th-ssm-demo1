package com.cskaoyan14th.mapper;

import com.cskaoyan14th.bean.DeviceMaintain;
import com.cskaoyan14th.bean.DeviceMaintainExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DeviceMaintainMapper {
    long countByExample(DeviceMaintainExample example);

    int deleteByExample(DeviceMaintainExample example);

    int deleteByPrimaryKey(String deviceMaintainId);

    int insert(DeviceMaintain record);

    int insertSelective(DeviceMaintain record);

    List<DeviceMaintain> selectByExample(DeviceMaintainExample example);

    DeviceMaintain selectByPrimaryKey(String deviceMaintainId);

    int updateByExampleSelective(@Param("record") DeviceMaintain record, @Param("example") DeviceMaintainExample example);

    int updateByExample(@Param("record") DeviceMaintain record, @Param("example") DeviceMaintainExample example);

    int updateByPrimaryKeySelective(DeviceMaintain record);

    int updateByPrimaryKey(DeviceMaintain record);

    /*上面是逆向工程自动生成的，下面是自己手动添加的*/

}