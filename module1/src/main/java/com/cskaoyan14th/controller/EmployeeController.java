package com.cskaoyan14th.controller;

import com.cskaoyan14th.bean.Department;
import com.cskaoyan14th.bean.Employee;
import com.cskaoyan14th.service.EmployeeService;
import com.cskaoyan14th.vo.Vo;
import com.cskaoyan14th.vo.ResponseVo;
import com.cskaoyan14th.vo.ResponseVoBox;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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

    /**
     * 以下为人员显示模块
     * @param session
     * @return
     */
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

    /**
     * 以下为人员添加模块
     * @return
     */
    @RequestMapping("add_judge")
    public String add_judge(){
        return "/WEB-INF/jsp/employee_add";
    }
    @RequestMapping("add")
    public String add(){
        return "/WEB-INF/jsp/employee_add";
    }

    @RequestMapping("insert")
    @ResponseBody
    public ResponseVo insert( Employee employee){
             int i = employeeService.insertEmployee(employee);
             ResponseVo box = new ResponseVoBox().Box(i);
             return box;
    }
    /**
     * 以下为人员编辑模块
     */
    @RequestMapping("edit_judge")
    public String edit_judge(){
        return "/WEB-INF/jsp/employee_edit";
    }
    @RequestMapping("edit")
    public String edit(){
        return "/WEB-INF/jsp/employee_edit";
    }

    @RequestMapping("update_all")
    @ResponseBody
    public ResponseVo update_all(Employee employee){
        int i = employeeService.updateEmployee(employee);
        ResponseVo box = new ResponseVoBox().Box(i);
        return box;
    }

    /**
     * 以下为删除模块
     * @return
     */
    @RequestMapping("delete_judge")
    @ResponseBody
    public String delete_judge(){
        return "";
    }

    @RequestMapping("delete_batch")
    @ResponseBody
    public ResponseVo delete_batch(String[] ids){
        int i = employeeService.deleteEmployee(ids);
        ResponseVo box = new ResponseVoBox().Box(i);
        return box;
    }

    /**
     * 以下为rest风格的Get模块
     * @param empId
     * @return ResponseVo
     */
    @RequestMapping("get/{empId}")
    @ResponseBody
    public Employee get(@PathVariable("empId") String empId){
        Employee employee = employeeService.queryEmploymentByEmpId(empId);
        return employee;
    }

    /**
     * 根据部门名称查询
     * @param searchValue
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping("search_employee_by_departmentName")
    @ResponseBody
    public Vo<Employee> searchByDepartmentName(String searchValue,int page,int rows){
        Vo<Employee> employeeResponseVo = employeeService.queryByDepartmentName(searchValue,page,rows);
        return employeeResponseVo;
    }

    /**
     * 根据empId查询
     * @param searchValue
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping("search_employee_by_employeeId")
    @ResponseBody
    public Vo<Employee> searchByEmpId(String searchValue,int page,int rows){
        Vo<Employee> employeeResponseVo = employeeService.searchByEmpId(searchValue,page,rows);
        return employeeResponseVo;
    }

    /**
     * 根据而empName查询
     * @param searchValue
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping("search_employee_by_employeeName")
    @ResponseBody
    public Vo<Employee> searchByEmpName(String searchValue,int page,int rows){
        Vo<Employee> employeeResponseVo = employeeService.searchByEmpName(searchValue,page,rows);
        return employeeResponseVo;
    }

}
