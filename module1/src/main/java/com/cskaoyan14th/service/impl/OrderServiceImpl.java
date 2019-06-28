package com.cskaoyan14th.service.impl;

import com.cskaoyan14th.bean.COrder;
import com.cskaoyan14th.bean.COrderExample;
import com.cskaoyan14th.mapper.COrderMapper;
import com.cskaoyan14th.service.OrderService;
import com.cskaoyan14th.vo.Vo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    COrderMapper orderMapper;

    /**
     *
     * @param page 页码
     * @param rows 每页条目数
     * @return 返回一个包含数目和当前页对象列表的封装对象，方便Controller返回json给前端
     */
    @Override
    public Vo<COrder> queryOrdersLeftCustomAndProduct(int page,int rows) {
        PageHelper.startPage(page,rows);
        //查询
        List<COrder> orderList1 = orderMapper.queryOrdersLeftCustomAndProduct();

        PageInfo<COrder> pageInfo = new PageInfo<>(orderList1);

        //一个包含数目和当前页对象列表的封装对象
        Vo<COrder> orderList = new Vo<>(pageInfo.getTotal(),pageInfo.getList());

        return orderList;
    }

    @Override
    public List<COrder> queryOrderLeftCustomAndProductById(int orderId) {
        return null;
    }

    @Override
    public int insertOrder(COrder order) {
        int insert = orderMapper.insert(order);
        return insert;
    }


    @Override
    public int updateOrder(COrder order) {
        int update = orderMapper.updateByPrimaryKey(order);
        System.out.println("插入后返回："+update);
        return update;
    }

    @Override
    public int deleteOrderByIds(String[] ids) {
        COrderExample example = new COrderExample();
        COrderExample.Criteria criteria = example.createCriteria();
        List<String> idList = new ArrayList<>();
        for (String id : ids) {
            idList.add(id);
        }
        criteria.andOrderIdIn(idList);
        int delete = orderMapper.deleteByExample(example);
        System.out.println(delete);
        return delete;
    }


}
