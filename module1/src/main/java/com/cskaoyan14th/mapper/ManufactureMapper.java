package com.cskaoyan14th.mapper;

import com.cskaoyan14th.bean.Manufacture;
import com.cskaoyan14th.bean.ManufactureExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ManufactureMapper {
    long countByExample(ManufactureExample example);

    int deleteByExample(ManufactureExample example);

    int deleteByPrimaryKey(String manufactureSn);

    int insert(Manufacture record);

    int insertSelective(Manufacture record);

    List<Manufacture> selectByExample(ManufactureExample example);

    Manufacture selectByPrimaryKey(String manufactureSn);

    int updateByExampleSelective(@Param("record") Manufacture record, @Param("example") ManufactureExample example);

    int updateByExample(@Param("record") Manufacture record, @Param("example") ManufactureExample example);

    int updateByPrimaryKeySelective(Manufacture record);

    int updateByPrimaryKey(Manufacture record);

    /*上面是逆向工程自动生成的，下面是自己手动添加的*/

    List<Manufacture> multiSelectAll();

}