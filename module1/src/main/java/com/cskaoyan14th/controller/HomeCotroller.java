package com.cskaoyan14th.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeCotroller {

    @RequestMapping("home")
    public String home(){
        return "/WEB-INF/jsp/home";
    }
}
