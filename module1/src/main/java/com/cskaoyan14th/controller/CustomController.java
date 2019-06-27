package com.cskaoyan14th.controller;

import com.cskaoyan14th.bean.Custom;
import com.cskaoyan14th.service.CustomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
}
