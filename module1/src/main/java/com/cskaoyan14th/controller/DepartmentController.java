package com.cskaoyan14th.controller;


import com.cskaoyan14th.bean.Department;
import com.cskaoyan14th.service.DepartmentService;
import com.cskaoyan14th.vo.Vo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 * 该类中是部门模块
 */
@Controller
@RequestMapping("department")
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;
    @RequestMapping("find")
    public String find (HttpSession session){

        ArrayList<String> objects = new ArrayList<>();
        objects.add("department:add");
        objects.add("department:edit");
        objects.add("department:delete");
        session.setAttribute("sysPermissionList",objects);
        return "WEB-INF/jsp/department_list";
    }

    /**
     * 部门显示模块
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping("list")
    @ResponseBody
    public Vo<Department> list(int page,int rows){
        Vo<Department> departmentVo = departmentService.queryDepartment(page,rows);
        return departmentVo;
    }
    @RequestMapping("add_judge")
    @ResponseBody
    public String add_judge(){
        return "";
    }
}
