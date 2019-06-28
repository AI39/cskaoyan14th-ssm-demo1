package com.cskaoyan14th.mapper;

import com.cskaoyan14th.bean.FinalMeasuretCheck;
import com.cskaoyan14th.bean.FinalMeasuretCheckExample;
import com.cskaoyan14th.bean.FinalMeasuretCheckVo;
import com.cskaoyan14th.bean.UnqualifyApply;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FinalMeasuretCheckMapper {
    long countByExample(FinalMeasuretCheckExample example);

    int deleteByExample(FinalMeasuretCheckExample example);

    int deleteByPrimaryKey(String fMeasureCheckId);

    int insert(FinalMeasuretCheck record);

    int insertSelective(FinalMeasuretCheck record);

    List<FinalMeasuretCheck> selectByExample(FinalMeasuretCheckExample example);

    FinalMeasuretCheck selectByPrimaryKey(String fMeasureCheckId);

    int updateByExampleSelective(@Param("record") FinalMeasuretCheck record, @Param("example") FinalMeasuretCheckExample example);

    int updateByExample(@Param("record") FinalMeasuretCheck record, @Param("example") FinalMeasuretCheckExample example);

    int updateByPrimaryKeySelective(FinalMeasuretCheck record);

    int updateByPrimaryKey(FinalMeasuretCheck record);

    /*上面是逆向工程自动生成的，下面是自己手动添加的*/
    //UnqualifyApply表左连接employee表还有product表
    List<FinalMeasuretCheckVo> queryFinalMeasureCheckLeftEmployee();
}