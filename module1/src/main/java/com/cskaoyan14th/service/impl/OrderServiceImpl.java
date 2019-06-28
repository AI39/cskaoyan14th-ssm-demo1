package com.cskaoyan14th.service.impl;

import com.cskaoyan14th.bean.COrder;
import com.cskaoyan14th.bean.COrderExample;
import com.cskaoyan14th.mapper.COrderMapper;
import com.cskaoyan14th.mapper.CustomMapper;
import com.cskaoyan14th.mapper.ProductMapper;
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
    @Autowired
    ProductMapper productMapper;
    @Autowired
    CustomMapper customMapper;

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

    @Override
    public COrder selectByIdLeftCustomAndProduct(String oid) {
        return orderMapper.selectByIdLeftCustomAndProduct(oid);
    }

    @Override
    public Vo<COrder> queryOrdersByOrderId(String searchValue, int page, int rows) {
        PageHelper.startPage(page,rows);
        //查询
        List<COrder> orderList1 = orderMapper.likeSelectById(searchValue);

        PageInfo<COrder> pageInfo = new PageInfo<>(orderList1);
        //一个包含数目和当前页对象列表的封装对象
        Vo<COrder> orderList = new Vo<>(pageInfo.getTotal(),pageInfo.getList());
        return orderList;
    }

    @Override
    public Vo<COrder> queryOrdersByProductName(String searchValue, int page, int rows) {
        PageHelper.startPage(page,rows);
        //查询
        List<String> idList = productMapper.likeSelectIdsByProductName(searchValue);
        //第一次查询为空时，返回空结果对象
        if (idList == null ||idList.size() == 0){
            return new Vo<COrder>(0,new ArrayList<COrder>());
        }
        List<COrder> orderList1 = orderMapper.selectByProductIds(idList);
        PageInfo<COrder> pageInfo = new PageInfo<>(orderList1);
        //一个包含数目和当前页对象列表的封装对象
        Vo<COrder> orderList = new Vo<>(pageInfo.getTotal(),pageInfo.getList());
        return orderList;
    }

    @Override
    public Vo<COrder> queryOrdersByCustomName(String searchValue, int page, int rows) {
        PageHelper.startPage(page,rows);
        //查询
        List<String> idList = customMapper.likeSelectIdsByCustomName(searchValue);
        //第一次查询为空时，返回空结果对象
        if (idList == null ||idList.size() == 0){
            return new Vo<COrder>(0,new ArrayList<COrder>());
        }
        List<COrder> orderList1 = orderMapper.selectByCustomIds(idList);
        PageInfo<COrder> pageInfo = new PageInfo<>(orderList1);
        //一个包含数目和当前页对象列表的封装对象
        Vo<COrder> orderList = new Vo<>(pageInfo.getTotal(),pageInfo.getList());
        return orderList;
    }

    @Override
    public List<COrder> queryOrders() {
        COrderExample example = new COrderExample();
        COrderExample.Criteria criteria = example.createCriteria();
        criteria.andOrderIdIsNotNull();
        List<COrder> orderList = orderMapper.selectByExample(example);
        return orderList;
    }

}
