package com.cskaoyan14th.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
@Controller
@RequestMapping("technology")
public class TechnologyController {

    @RequestMapping("find")
    public String technologymanage(HttpSession session){
        ArrayList<Object> objects = new ArrayList<>();
        objects.add("technology:add");
        objects.add("technology:edit");
        objects.add("technology:delete");
        session.setAttribute("sysPermissionList",objects);
        return "/WEB-INF/jsp/technology_list";
    }

}
