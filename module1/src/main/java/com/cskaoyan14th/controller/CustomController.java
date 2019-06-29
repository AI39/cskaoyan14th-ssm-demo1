package com.cskaoyan14th.controller;

import com.cskaoyan14th.bean.Custom;
import com.cskaoyan14th.service.CustomService;
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
@RequestMapping("custom")
public class CustomController {

    @Autowired
    CustomService customService;

    @RequestMapping("get/{cid}")
    @ResponseBody
    public Custom get(@PathVariable("cid") String cid){
        Custom custom = customService.queryCustomById(cid);
        return custom;
    }

    @RequestMapping("find")
    public String find(HttpServletRequest request){
        List<String> sysPermissionList = new ToolbarButtons("custom").getSysPermissionList();
        request.getSession().setAttribute("sysPermissionList",sysPermissionList);
        return "WEB-INF/jsp/custom_list";
    }
    @RequestMapping("list")
    @ResponseBody
    public Vo<Custom> getList(int page,int rows){
        Vo<Custom> customList = customService.queryCustomListPage(page,rows);
        return customList;
    }

    /*
    增加用户的三个请求
     */
    @RequestMapping("add_judge")
    @ResponseBody
    public String addJudge(){
        return "";
    }
    @RequestMapping("add")
    public String add(){
        return "WEB-INF/jsp/custom_add";
    }
    @RequestMapping("insert")
    @ResponseBody
    public ResponseVo insert(Custom custom){
        ResponseVo responseVo = new ResponseVo();
        int insert = customService.addCustom(custom);
        if (insert == 1){
            responseVo.setStatus(200);
            responseVo.setMsg("OK");
        }else if (insert == 0){
            responseVo.setStatus(0);
            responseVo.setMsg("客户编号已经存在！请更改");
        }else {
            responseVo.setStatus(400);
            responseVo.setMsg("服务器错误，请稍后再试");
        }
        return responseVo;
    }

    /*
    修改客户的3个请求
     */
    @RequestMapping("edit_judge")
    @ResponseBody
    public String editJudge(){
        return "";
    }
    @RequestMapping("edit")
    public String edit(){
        return "WEB-INF/jsp/custom_edit";
    }
    @RequestMapping("update_all")
    @ResponseBody
    public ResponseVo updateCustom(Custom custom){
        ResponseVo responseVo = new ResponseVo();
        int update = customService.updateCustom(custom);
        if (update == 1){
            responseVo.setStatus(200);
            responseVo.setMsg("OK");
        }else if (update == 0){
            responseVo.setStatus(0);
            responseVo.setMsg("修改失败");
        }else {
            responseVo.setStatus(500);
            responseVo.setMsg("服务器错误，请稍后再试");
        }
        return responseVo;
    }

    /*
    删除客户
     */
    @RequestMapping("delete_judge")
    @ResponseBody
    public String deleteJudge(){
        return "";
    }
    @RequestMapping("delete_batch")
    @ResponseBody
    public ResponseVo deleteProducts(String[] ids){
        ResponseVo responseVo = new ResponseVo();
        int delete = customService.deleteCustomsByIds(ids);
        if (delete > 0){
            responseVo.setMsg("OK");
            responseVo.setStatus(200);
        }else {
            responseVo.setStatus(0);
            responseVo.setMsg("删除失败");
        }
        return responseVo;
    }

    @RequestMapping("search_custom_by_customId")
    @ResponseBody
    public Vo<Custom> searchCustomByCustomId(String searchValue,int page,int rows){
        Vo<Custom> customList = customService.queryCustomsByCustomId(searchValue,page,rows);
        return customList;
    }
    @RequestMapping("search_custom_by_customName")
    @ResponseBody
    public Vo<Custom> searchCustomByCustomName(String searchValue,int page,int rows){
        Vo<Custom> customList = customService.queryCustomsByCustomName(searchValue,page,rows);
        return customList;
    }
}
