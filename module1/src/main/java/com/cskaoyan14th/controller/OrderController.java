package com.cskaoyan14th.controller;

import com.cskaoyan14th.bean.COrder;
import com.cskaoyan14th.bean.COrderExample;
import com.cskaoyan14th.mapper.COrderMapper;
import com.cskaoyan14th.util.ToolbarButtons;
import com.cskaoyan14th.vo.Vo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("order")
public class OrderController {

    @Autowired
    COrderMapper orderMapper;

    @RequestMapping("find")
    public String find(HttpServletRequest request){
        //System.out.println("order/find进来了吗？");
        List<String> sysPermissionList = new ToolbarButtons("order").getSysPermissionList();
        request.getSession().setAttribute("sysPermissionList",sysPermissionList);
        return "WEB-INF/jsp/order_list";
    }

    @RequestMapping("list")
    @ResponseBody
    public Vo<COrder> list(int page, int rows){
        PageHelper.startPage(page,rows);
        COrderExample orderExample = new COrderExample();
        COrderExample.Criteria criteria = orderExample.createCriteria();
        criteria.andCustomIdIsNotNull();
        List<COrder> orderList1 = orderMapper.selectByExample(orderExample);

        PageInfo<COrder> pageInfo = new PageInfo<>(orderList1);

        //List<COrder> orderList = pageInfo.getList();
        Vo<COrder> orderList = new Vo<>(pageInfo.getTotal(),pageInfo.getList());
        System.out.println(orderList);
        return orderList;
    }

}
