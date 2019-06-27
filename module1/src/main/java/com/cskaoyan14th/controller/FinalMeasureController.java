package com.cskaoyan14th.controller;

import com.cskaoyan14th.util.MyUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Yuechao Yang
 * @version 2019-06-26-21:48
 */
@Controller
@RequestMapping("measure")
public class FinalMeasureController {

    @RequestMapping("find")
    public String find(HttpServletRequest request){
        MyUtil.sysPermissionList(request);
        return "WEB-INF/jsp/measurement_list";
    }
}
