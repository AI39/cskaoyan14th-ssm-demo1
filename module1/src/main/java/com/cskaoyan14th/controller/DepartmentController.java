package com.cskaoyan14th.controller;


import com.cskaoyan14th.bean.Department;
import com.cskaoyan14th.service.DepartmentService;
import com.cskaoyan14th.vo.ResponseVo;
import com.cskaoyan14th.vo.ResponseVoBox;
import com.cskaoyan14th.vo.Vo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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

    /**
     * 部门增加模块
     * @return
     */
    @RequestMapping("add_judge")
    @ResponseBody
    public String add_judge(){
        return "";
    }

    @RequestMapping("add")
    public String add(){
        return "WEB-INF/jsp/department_add";
    }

    @RequestMapping("insert")
    @ResponseBody
    public ResponseVo insert(Department department){
        int i = departmentService.insertDepartment(department);
        ResponseVo box = new ResponseVoBox().Box(i);
        return box;
    }

    /**
     * 编辑部门模块
     * @return
     */
    @RequestMapping("edit_judge")
    @ResponseBody
    public String edit_judge(){
        return "edit_judge";
    }

    @RequestMapping("edit")
    public String edit(){
        return "WEB-INF/jsp/department_edit";
    }
    @RequestMapping("update_all")
    @ResponseBody
    public ResponseVo update(Department department){
        int i = departmentService.updateDepartment(department);
        ResponseVo box = new ResponseVoBox().Box(i);
        return box;
    }

    /**
     * 删除模块
     * @return
     */
    @RequestMapping("delete_judge")
    @ResponseBody
    public String delete_judge(){
        return "";
    }

    @RequestMapping("delete_batch")
    @ResponseBody
    public ResponseVo delete(String[] ids){
        int i = departmentService.deleteDepartment(ids);
        ResponseVo box = new ResponseVoBox().Box(i);
        return box;
    }

    /**
     * 根据Id模糊查询
     * @param searchValue
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping("search_department_by_departmentId")
    @ResponseBody
    public Vo<Department> search(String  searchValue,int page,int rows){
        Vo<Department> departmentVo = departmentService.searchDepartmentById(searchValue,page,rows);
        return departmentVo;
    }

    /**
     * 根据名字模糊查询
     * @param searchValue
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping("search_department_by_departmentName")
    @ResponseBody
    public Vo<Department> searchByName(String  searchValue,int page,int rows){
        Vo<Department> departmentVo = departmentService.searchDepartmentByName(searchValue,page,rows);
        return departmentVo;
    }

    @RequestMapping("update_note")
    @ResponseBody
    public ResponseVo update_note(String departmentId,String note){
        int i = departmentService.updateNoteDepartment(departmentId,note);
        ResponseVo box = new ResponseVoBox().Box(i);
        return box;
    }

    /**
     * 以下为rest风格的Get模块
     * @param depId
     * @return ResponseVo
     */
    @RequestMapping("get/{depId}")
    @ResponseBody
    public Department get(@PathVariable("depId") String depId){
        Department department = departmentService.queryDepartmentById(depId);
        return department;
    }
}
