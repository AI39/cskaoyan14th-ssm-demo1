package com.cskaoyan14th.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Yuechao Yang
 * @version 2019-06-26-21:48
 */
@Controller
@RequestMapping("measure")
public class FinalMeasureController {

    @RequestMapping("find")
    public String find(){
        return "WEB-INF/jsp/measurement_list";
    }
}
