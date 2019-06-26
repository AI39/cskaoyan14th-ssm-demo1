package com.cskaoyan14th.controller;

import com.cskaoyan14th.bean.Material;
import com.cskaoyan14th.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Controller
@RequestMapping("material")
public class MaterialController {
    @Autowired
    MaterialService materialService;

    @RequestMapping("find")
    public String materialInfoFind(HttpSession session){
        ArrayList<String> objects = new ArrayList<>();
        objects.add("material:add");
        objects.add("material:edit");
        objects.add("material:delete");
        session.setAttribute("sysPermissionList",objects);
        return "/WEB-INF/jsp/material_list";
    }


    @RequestMapping("list")
    @ResponseBody
    public Page<Material> materialInfoList(int page,int rows){
        Page<Material> materialPage = materialService.getMaterialPage(page,rows);
        return materialPage;
    }

   /* @RequestMapping("add")
    public String materialInfoAdd(){
        return null;
    }*/



}
