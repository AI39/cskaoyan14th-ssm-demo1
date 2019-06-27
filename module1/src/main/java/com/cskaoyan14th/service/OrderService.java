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
}
