package com.cskaoyan14th.controller;


import com.cskaoyan14th.utils.MyUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.servlet.http.HttpServletRequest;

/**
 * @author Yuechao Yang
 * @version 2019-06-26-17:10
 */
@Controller
@RequestMapping("unqualify")
public class UnqualifyController {


    @RequestMapping("find")
    public String find(HttpServletRequest request){
        MyUtil.sysPermissionList(request);
        return "WEB-INF/jsp/unqualify_list";                                                                        /*这里面需要调用query写json返回*/
    }

}
