package com.cskaoyan14th.controller;

import com.cskaoyan14th.util.MyUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Yuechao Yang
 * @version 2019-06-26-21:49
 */
@Controller
@RequestMapping("p_count_check")
public class ProcessCountController {

    @RequestMapping("find")
    public String find(HttpServletRequest request){

        MyUtil.sysPermissionList(request);
        return "WEB-INF/jsp/p_count_check_list";
    }
}
