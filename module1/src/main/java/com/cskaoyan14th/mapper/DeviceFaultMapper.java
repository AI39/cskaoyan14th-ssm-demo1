package com.cskaoyan14th.mapper;

import com.cskaoyan14th.bean.DeviceFault;
import com.cskaoyan14th.bean.DeviceFaultExample;
import com.cskaoyan14th.bean.DeviceFaultShow;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DeviceFaultMapper {
    long countByExample(DeviceFaultExample example);

    int deleteByExample(DeviceFaultExample example);

    int deleteByPrimaryKey(String deviceFaultId);

    int insert(DeviceFault record);

    int insertSelective(DeviceFault record);

    List<DeviceFault> selectByExample(DeviceFaultExample example);

    DeviceFault selectByPrimaryKey(String deviceFaultId);

    int updateByExampleSelective(@Param("record") DeviceFault record, @Param("example") DeviceFaultExample example);

    int updateByExample(@Param("record") DeviceFault record, @Param("example") DeviceFaultExample example);

    int updateByPrimaryKeySelective(DeviceFault record);

    int updateByPrimaryKey(DeviceFault record);


    /*上面是逆向工程自动生成的，下面是自己手动添加的*/

    List<DeviceFaultShow> selectDeviceFaultShow();

    List<DeviceFaultShow> selectDeviceFaultShowBySingleConditionLike(@Param("type") String type, @Param("searchValue") String searchValue);
}