package com.cskaoyan14th.service;

import com.cskaoyan14th.bean.COrder;
import com.cskaoyan14th.vo.Vo;

import java.util.List;

/**
 * 计划进度模块的订单管理service
 */

public interface OrderService {

    Vo<COrder> queryOrdersLeftCustomAndProduct(int page, int rows);
    List<COrder> queryOrderLeftCustomAndProductById(int orderId);
    int insertOrder(COrder order);
    int updateOrder(COrder order);

    int deleteOrderByIds(String[] ids);

    COrder selectByIdLeftCustomAndProduct(String oid);
    Vo<COrder> queryOrdersByOrderId(String searchValue,int page, int rows);
    Vo<COrder> queryOrdersByProductName(String searchValue,int page, int rows);
    Vo<COrder> queryOrdersByCustomName(String searchValue,int page, int rows);
}
