package com.cskaoyan14th.mapper;

import com.cskaoyan14th.bean.MaterialConsume;
import com.cskaoyan14th.bean.MaterialConsumeExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MaterialConsumeMapper {
    long countByExample(MaterialConsumeExample example);

    int deleteByExample(MaterialConsumeExample example);

    int deleteByPrimaryKey(String consumeId);

    int insert(MaterialConsume record);

    int insertSelective(MaterialConsume record);

    List<MaterialConsume> selectByExample(MaterialConsumeExample example);

    MaterialConsume selectByPrimaryKey(String consumeId);

    int updateByExampleSelective(@Param("record") MaterialConsume record, @Param("example") MaterialConsumeExample example);

    int updateByExample(@Param("record") MaterialConsume record, @Param("example") MaterialConsumeExample example);

    int updateByPrimaryKeySelective(MaterialConsume record);

    int updateByPrimaryKey(MaterialConsume record);

    /*上面是逆向工程自动生成的，下面是自己手动添加的*/

    List<MaterialConsume> selectMaterialConsume();

    List<MaterialConsume> selectMaterialConsumeByConsumeId(@Param("consumeid")String consumeid);

    List<MaterialConsume> selectMaterialConsumeByWorkId(@Param("workid")String workid);

    List<MaterialConsume> selectMaterialConsumeByMaterialId(@Param("materialid")String materialid);

}