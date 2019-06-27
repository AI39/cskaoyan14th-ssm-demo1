package com.cskaoyan14th.controller;

import com.cskaoyan14th.bean.Technology;
import com.cskaoyan14th.service.TechnologyService;
import com.cskaoyan14th.vo.Vo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
@Controller
public class TechnologyController {
    @Autowired
    TechnologyService technologyService;

    @RequestMapping("/technology/find")
    public String technologymanage(HttpSession session){
        ArrayList<Object> objects = new ArrayList<>();
        objects.add("technology:add");
        objects.add("technology:edit");
        objects.add("technology:delete");
        session.setAttribute("sysPermissionList",objects);
        return "/WEB-INF/jsp/technology_list";
    }

    @RequestMapping("/technology/list")
    @ResponseBody
    public Vo<Technology> technologyList(int page,int rows){

        Vo<Technology> technologyVo = technologyService.getTechnologyVo(page,rows);
        return technologyVo;

    }
}
