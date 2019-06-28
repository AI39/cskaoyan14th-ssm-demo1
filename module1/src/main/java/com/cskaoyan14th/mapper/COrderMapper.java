package com.cskaoyan14th.mapper;

import com.cskaoyan14th.bean.COrder;
import com.cskaoyan14th.bean.COrderExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface COrderMapper {
    long countByExample(COrderExample example);

    int deleteByExample(COrderExample example);

    int deleteByPrimaryKey(String orderId);

    int insert(COrder record);

    int insertSelective(COrder record);

    List<COrder> selectByExample(COrderExample example);

    COrder selectByPrimaryKey(String orderId);

    int updateByExampleSelective(@Param("record") COrder record, @Param("example") COrderExample example);

    int updateByExample(@Param("record") COrder record, @Param("example") COrderExample example);

    int updateByPrimaryKeySelective(COrder record);

    int updateByPrimaryKey(COrder record);

    /*上面是逆向工程自动生成的，下面是自己手动添加的*/
    //c_order表左连接custom表和product表
    List<COrder> queryOrdersLeftCustomAndProduct();
    int updateOrder(COrder order);

}