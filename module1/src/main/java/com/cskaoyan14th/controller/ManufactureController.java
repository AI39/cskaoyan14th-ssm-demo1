package com.cskaoyan14th.controller;

import com.cskaoyan14th.bean.Manufacture;
import com.cskaoyan14th.service.impl.ManufactureServiceImpl;
import com.cskaoyan14th.util.ToolbarButtons;
import com.cskaoyan14th.vo.ResponseVo;
import com.cskaoyan14th.vo.Vo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/manufacture")
public class ManufactureController {
    @Autowired
    ManufactureServiceImpl manufactureService;

    @RequestMapping("/find")
    public ModelAndView find(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        List<String> sysPermissionList = new ToolbarButtons("manufacture").getSysPermissionList();
        request.getSession().setAttribute("sysPermissionList",sysPermissionList);
        modelAndView.setViewName("/WEB-INF/jsp/manufacture_list");
        return modelAndView;
    }

    @RequestMapping("/list")
    @ResponseBody
    public Vo<Manufacture> list(int page, int rows) {
        //System.out.println(manufactureService.getManufactureList(page, rows));
        return manufactureService.getManufactureList(page, rows);
    }

    @RequestMapping("/add_judge")
    @ResponseBody
    public String add_judge() {
        return "";
    }

    @RequestMapping("/add")
    public String add() {
        return "/WEB-INF/jsp/manufacture_add";
    }

    @RequestMapping("/insert")
    @ResponseBody
    public ResponseVo insert(Manufacture manufacture){
        ResponseVo responseVo = new ResponseVo();
        int i = manufactureService.insert(manufacture);
        if (i > 0){
            responseVo.setMsg("OK");
            responseVo.setStatus(200);
        }else {
            responseVo.setStatus(500);
            responseVo.setMsg("ERROR");
        }
        return responseVo;
    }

    @RequestMapping("/edit_judge")
    @ResponseBody
    public String edit_judge() {
        return "";
    }

    @RequestMapping("/edit")
    public String edit() {
        return "/WEB-INF/jsp/manufacture_edit";
    }

    @RequestMapping("/update_all")
    @ResponseBody
    public ResponseVo update_all(Manufacture manufacture){
        ResponseVo responseVo = new ResponseVo();
        int i = manufactureService.updateByPrimaryKeySelective(manufacture);
        if (i > 0){
            responseVo.setMsg("OK");
            responseVo.setStatus(200);
        }else {
            responseVo.setStatus(500);
            responseVo.setMsg("ERROR");
        }
        return responseVo;
    }

    @RequestMapping("/delete_judge")
    @ResponseBody
    public String delete_judge() {
        return "";
    }

    @RequestMapping("/delete_batch")
    @ResponseBody
    public ResponseVo delete_batch(String[] ids) {
        ResponseVo responseVo = new ResponseVo();
        int i = manufactureService.deleteByIds(ids);
        if (i > 0){
            responseVo.setMsg("OK");
            responseVo.setStatus(200);
        }else {
            responseVo.setStatus(500);
            responseVo.setMsg("ERROR");
        }
        return responseVo;
    }
}
