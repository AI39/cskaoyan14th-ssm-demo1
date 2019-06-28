package com.cskaoyan14th.mapper;

import com.cskaoyan14th.bean.Work;
import com.cskaoyan14th.bean.WorkExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WorkMapper {
    long countByExample(WorkExample example);

    int deleteByExample(WorkExample example);

    int deleteByPrimaryKey(String workId);

    int insert(Work record);

    int insertSelective(Work record);

    List<Work> selectByExample(WorkExample example);

    Work selectByPrimaryKey(String workId);

    int updateByExampleSelective(@Param("record") Work record, @Param("example") WorkExample example);

    int updateByExample(@Param("record") Work record, @Param("example") WorkExample example);

    int updateByPrimaryKeySelective(Work record);

    int updateByPrimaryKey(Work record);

    /*上面是逆向工程自动生成的，下面是自己手动添加的*/

    List<Work> multiSelectAll();

    Work multiSelectByWorkId(@Param("id") String id);

    int deleteByIds(@Param("ids") String[] ids);

    List<Work> multiSelectByLikeWorkId(@Param("id") String id);

    List<Work> multiSelectByProductIds(@Param("ids") List<String> ids);

    List<Work> multiSelectByDeviceIds(@Param("ids") List<String> ids);

    List<Work> multiSelectByProcessIds(@Param("ids") List<String> ids);
}