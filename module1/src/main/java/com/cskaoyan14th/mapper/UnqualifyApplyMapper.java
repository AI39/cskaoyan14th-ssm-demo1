package com.cskaoyan14th.mapper;

import com.cskaoyan14th.bean.COrder;
import com.cskaoyan14th.bean.UnqualifyApply;
import com.cskaoyan14th.bean.UnqualifyApplyExample;
import com.cskaoyan14th.vo.Vo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UnqualifyApplyMapper {
    long countByExample(UnqualifyApplyExample example);

    int deleteByExample(UnqualifyApplyExample example);

    int deleteByPrimaryKey(String unqualifyApplyId);

    int insert(UnqualifyApply record);

    int insertSelective(UnqualifyApply record);

    List<UnqualifyApply> selectByExample(UnqualifyApplyExample example);

    UnqualifyApply selectByPrimaryKey(String unqualifyApplyId);

    int updateByExampleSelective(@Param("record") UnqualifyApply record, @Param("example") UnqualifyApplyExample example);

    int updateByExample(@Param("record") UnqualifyApply record, @Param("example") UnqualifyApplyExample example);

    int updateByPrimaryKeySelective(UnqualifyApply record);

    int updateByPrimaryKey(UnqualifyApply record);

    /*上面是逆向工程自动生成的，下面是自己手动添加的*/
    //UnqualifyApply表左连接employee表还有product表
    List<UnqualifyApply> queryUnqualifyApplyLeftEmployeeAndProduct();                                                             /*用于json数据的查询*/

    List<UnqualifyApply> searchByProductName(String productName);
}