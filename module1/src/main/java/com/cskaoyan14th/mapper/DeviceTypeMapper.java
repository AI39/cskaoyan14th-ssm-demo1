package com.cskaoyan14th.mapper;

import com.cskaoyan14th.bean.DeviceType;
import com.cskaoyan14th.bean.DeviceTypeExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DeviceTypeMapper {
    long countByExample(DeviceTypeExample example);

    int deleteByExample(DeviceTypeExample example);

    int deleteByPrimaryKey(String deviceTypeId);

    int insert(DeviceType record);

    int insertSelective(DeviceType record);

    List<DeviceType> selectByExample(DeviceTypeExample example);

    DeviceType selectByPrimaryKey(String deviceTypeId);

    int updateByExampleSelective(@Param("record") DeviceType record, @Param("example") DeviceTypeExample example);

    int updateByExample(@Param("record") DeviceType record, @Param("example") DeviceTypeExample example);

    int updateByPrimaryKeySelective(DeviceType record);

    int updateByPrimaryKey(DeviceType record);

    int selectPageDeviceTypeCount(@Param("limit") int limit, @Param("offset")int offset);

    List<DeviceType> selectPageDeviceTypeList(@Param("limit") int limit, @Param("offset") int offset);

    /*上面是逆向工程自动生成的，下面是自己手动添加的*/

}