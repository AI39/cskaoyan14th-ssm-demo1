package com.cskaoyan14th.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Yuechao Yang
 * @version 2019-06-26-21:48
 */
@Controller
@RequestMapping("f_count_check")
public class FinalCountController {

    @RequestMapping("find")
    public String find(){
        return "WEB-INF/jsp/f_count_check_list";
    }
}
