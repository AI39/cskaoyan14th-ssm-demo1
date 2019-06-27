package com.cskaoyan14th.controller;

import com.cskaoyan14th.bean.Manufacture;
import com.cskaoyan14th.service.impl.manufactureServiceImpl;
import com.cskaoyan14th.util.ToolbarButtons;
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
    manufactureServiceImpl manufactureService;

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
}
