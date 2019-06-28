package com.cskaoyan14th.controller;

import com.cskaoyan14th.util.MyUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 * 该类中是部门模块
 */
@Controller
@RequestMapping("department")
public class DepartmentController {
    @RequestMapping("find")
    public String find (HttpSession session){

        ArrayList<String> objects = new ArrayList<>();
        objects.add("department:add");
        objects.add("department:edit");
        objects.add("department:delete");
        session.setAttribute("sysPermissionList",objects);
        return "WEB-INF/jsp/department_list";
    }
}
