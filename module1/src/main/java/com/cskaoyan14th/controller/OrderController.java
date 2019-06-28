package com.cskaoyan14th.controller;

import com.cskaoyan14th.bean.COrder;
import com.cskaoyan14th.service.OrderService;
import com.cskaoyan14th.util.ToolbarButtons;
import com.cskaoyan14th.vo.ResponseVo;
import com.cskaoyan14th.vo.Vo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @RequestMapping("get/{oid}")
    @ResponseBody
    public COrder get(@PathVariable("oid") String oid){
        return orderService.selectByIdLeftCustomAndProduct(oid);
    }

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

    @RequestMapping("edit_judge")
    @ResponseBody
    public String editJudge(){return "";}

    @RequestMapping("edit")
    public String edit(){
        return "WEB-INF/jsp/order_edit";
    }
    @RequestMapping("update_all")
    @ResponseBody
    public ResponseVo updateAll(COrder order){
        ResponseVo responseVo = new ResponseVo();
        int update = orderService.updateOrder(order);
        if (update == 1){
            responseVo.setMsg("OK");
            responseVo.setStatus(200);
        }else {
            responseVo.setMsg("ERROR");
            responseVo.setStatus(400);
        }
        return responseVo;
    }

    @RequestMapping("delete_judge")
    @ResponseBody
    public String deleteJudge(){
        return "";
    }
    @RequestMapping("delete_batch")
    @ResponseBody
    public ResponseVo deleteBatch(String[] ids){
        ResponseVo responseVo = new ResponseVo();
        int delete = orderService.deleteOrderByIds(ids);
        if (delete <= 0){
            responseVo.setStatus(400);
            responseVo.setMsg("删除失败");
        } else {
            responseVo.setMsg("OK");
            responseVo.setStatus(200);
        }
        return responseVo;
    }

    @RequestMapping("search_order_by_orderId")
    @ResponseBody
    public Vo<COrder> searchOrderByOrderId(String searchValue,int page,int rows){
        Vo<COrder> orderList = orderService.queryOrdersByOrderId(searchValue, page, rows);
        return orderList;
    }
    @RequestMapping("search_order_by_orderCustom")
    @ResponseBody
    public Vo<COrder> searchOrderByOrderCustomName(String searchValue,int page,int rows){
        Vo<COrder> orderList = orderService.queryOrdersByCustomName(searchValue, page, rows);
        return orderList;
    }
    @RequestMapping("search_order_by_orderProduct")
    @ResponseBody
    public Vo<COrder> searchOrderByOrderProductName(String searchValue,int page,int rows){
        Vo<COrder> orderList = orderService.queryOrdersByProductName(searchValue, page, rows);
        return orderList;
    }

}
