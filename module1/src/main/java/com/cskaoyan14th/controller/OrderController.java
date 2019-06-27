package com.cskaoyan14th.controller;

import com.cskaoyan14th.bean.COrder;
import com.cskaoyan14th.service.OrderService;
import com.cskaoyan14th.util.ToolbarButtons;
import com.cskaoyan14th.vo.ResponseVo;
import com.cskaoyan14th.vo.Vo;
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
    OrderService orderService;

    @RequestMapping("find")
    public String find(HttpServletRequest request){
        List<String> sysPermissionList = new ToolbarButtons("order").getSysPermissionList();
        request.getSession().setAttribute("sysPermissionList",sysPermissionList);
        return "WEB-INF/jsp/order_list";
    }

    @RequestMapping("list")
    @ResponseBody
    public Vo<COrder> list(int page, int rows){
        Vo<COrder> orderList = orderService.queryOrdersLeftCustomAndProduct(page, rows);
        return orderList;
    }

    @RequestMapping("add_judge")
    @ResponseBody
    public String addOrderPage(){
        return "";
    }
    @RequestMapping("add")
    public String add(){
        return "WEB-INF/jsp/order_add";
    }


    /**
     * 处理order_add的表单，并加入数据库
     * @param order
     * @return
     */
    @RequestMapping("insert")
    @ResponseBody
    public ResponseVo insert(COrder order){
        ResponseVo responseVo = new ResponseVo();
        int insert = orderService.insertOrder(order);
        if (insert == 1){
            responseVo.setMsg("OK");
            responseVo.setStatus(200);
        }else {
            responseVo.setStatus(500);
            responseVo.setMsg("ERROR");
        }
        return responseVo;
    }
}
