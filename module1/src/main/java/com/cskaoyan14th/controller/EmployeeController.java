package com.cskaoyan14th.controller;

import com.cskaoyan14th.bean.Employee;
import com.cskaoyan14th.mapper.EmployeeMapper;
import com.cskaoyan14th.vo.Vo;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.aspectj.lang.annotation.Before;
import org.aspectj.weaver.ast.Var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * 该类中是员工模块
 */
@Controller
@RequestMapping("employee")
public class EmployeeController {
    @Autowired
    SqlSessionFactory sqlSessionFactory;
   @Autowired
   EmployeeMapper employeeMapper;

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


        List<Employee> employees = employeeMapper.queryMember();
        System.out.println(employees);
        long i = employeeMapper.queryCount();
        PageHelper.startPage(page,rows);
        Vo<Employee> employeeVo = new Vo<>(i,employees);

        return employeeVo;
    }

}
