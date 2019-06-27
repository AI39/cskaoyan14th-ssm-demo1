package com.cskaoyan14th.controller;

import com.cskaoyan14th.bean.Work;
import com.cskaoyan14th.service.impl.WorkServiceImpl;
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
@RequestMapping("/work")
public class WorkController {
    @Autowired
    WorkServiceImpl workService;

    @RequestMapping("/find")
    public ModelAndView find(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        List<String> sysPermissionList = new ToolbarButtons("work").getSysPermissionList();
        request.getSession().setAttribute("sysPermissionList",sysPermissionList);
        modelAndView.setViewName("/WEB-INF/jsp/work_list");
        return modelAndView;
    }

    @RequestMapping("/list")
    @ResponseBody
    public Vo<Work> list(int page, int rows) {
        //System.out.println(workService.getWorkList(page, rows));
        return workService.getWorkList(page, rows);
    }
}
