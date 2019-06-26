package com.cskaoyan14th.mapper;

import com.cskaoyan14th.bean.DeviceCheck;
import com.cskaoyan14th.bean.DeviceCheckExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DeviceCheckMapper {
    long countByExample(DeviceCheckExample example);

    int deleteByExample(DeviceCheckExample example);

    int deleteByPrimaryKey(String deviceCheckId);

    int insert(DeviceCheck record);

    int insertSelective(DeviceCheck record);

    List<DeviceCheck> selectByExample(DeviceCheckExample example);

    DeviceCheck selectByPrimaryKey(String deviceCheckId);

    int updateByExampleSelective(@Param("record") DeviceCheck record, @Param("example") DeviceCheckExample example);

    int updateByExample(@Param("record") DeviceCheck record, @Param("example") DeviceCheckExample example);

    int updateByPrimaryKeySelective(DeviceCheck record);

    int updateByPrimaryKey(DeviceCheck record);

    /*上面是逆向工程自动生成的，下面是自己手动添加的*/

}