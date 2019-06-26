package com.cskaoyan14th.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Yuechao Yang
 * @version 2019-06-26-21:49
 */
@Controller
@RequestMapping("p_count_check")
public class ProcessCountController {

    @RequestMapping("find")
    public String find(){
        return "WEB-INF/jsp/p_count_check_list";
    }
}
