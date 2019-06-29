package com.cskaoyan14th.mapper;

import com.cskaoyan14th.bean.Product;
import com.cskaoyan14th.bean.ProductExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductMapper {
    long countByExample(ProductExample example);

    int deleteByExample(ProductExample example);

    int deleteByPrimaryKey(String productId);

    int insert(Product record);

    int insertSelective(Product record);

    List<Product> selectByExample(ProductExample example);

    Product selectByPrimaryKey(String productId);

    int updateByExampleSelective(@Param("record") Product record, @Param("example") ProductExample example);

    int updateByExample(@Param("record") Product record, @Param("example") ProductExample example);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);

    /*上面是逆向工程自动生成的，下面是自己手动添加的*/
    //订单表的模糊查询,先在product表模糊查询产品名
    List<String> likeSelectIdsByProductName(String pname);
    //模糊查询产品表
    List<Product> likeSelectProductsByProductId(String pid);
    List<Product> likeSelectProductsByProductName(String pname);
    List<Product> likeSelectProductsByProductType(String ptype);
}