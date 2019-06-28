package com.cskaoyan14th.controller;

import com.cskaoyan14th.bean.Employee;
import com.cskaoyan14th.service.EmployeeService;
import com.cskaoyan14th.vo.Vo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 * 该类中是员工模块
 */
@Controller
@RequestMapping("employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @RequestMapping("find")
    public String find (HttpSession session){
        ArrayList<String> objects = new ArrayList<>();
        objects.add("employee:add");
        objects.add("employee:edit");
        objects.add("employee:delete");
        session.setAttribute("sysPermissionList",objects);
        return "/WEB-INF/jsp/employee_list";
    }

    @RequestMapping("list")
    @ResponseBody
    public Vo<Employee>  list(int page ,int rows){
        Vo<Employee> employeeVo = employeeService.queryEmployment(page, rows);
        return employeeVo;
    }
}
