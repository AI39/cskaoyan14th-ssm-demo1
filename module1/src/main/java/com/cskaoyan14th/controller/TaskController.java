package com.cskaoyan14th.controller;

import com.cskaoyan14th.bean.Task;
import com.cskaoyan14th.service.impl.TaskServiceImpl;
import com.cskaoyan14th.util.ToolbarButtons;
import com.cskaoyan14th.vo.ResponseVo;
import com.cskaoyan14th.vo.Vo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/task")
public class TaskController {
    @Autowired
    TaskServiceImpl taskService;

    @RequestMapping("/find")
    public ModelAndView find(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        List<String> sysPermissionList = new ToolbarButtons("task").getSysPermissionList();
        request.getSession().setAttribute("sysPermissionList",sysPermissionList);
        modelAndView.setViewName("/WEB-INF/jsp/task_list");
        return modelAndView;
    }

    @RequestMapping("/list")
    @ResponseBody
    public Vo<Task> list(int page, int rows) {
        //System.out.println(taskService.getTaskList(page, rows));
        return taskService.getTaskList(page, rows);
    }

    @RequestMapping("/add_judge")
    @ResponseBody
    public String add_judge() {
        return "";
    }

    @RequestMapping("/add")
    public String add() {
        return "/WEB-INF/jsp/task_add";
    }

    @RequestMapping("/insert")
    @ResponseBody
    public ResponseVo insert(Task task){
        ResponseVo responseVo = new ResponseVo();
        int i = taskService.insert(task);
        if (i > 0){
            responseVo.setMsg("OK");
            responseVo.setStatus(200);
        }else {
            responseVo.setStatus(500);
            responseVo.setMsg("ERROR");
        }
        return responseVo;
    }

    @RequestMapping("/edit_judge")
    @ResponseBody
    public String edit_judge() {
        return "";
    }

    @RequestMapping("/edit")
    public String edit() {
        return "/WEB-INF/jsp/task_edit";
    }

    @RequestMapping("/update_all")
    @ResponseBody
    public ResponseVo update_all(Task task){
        ResponseVo responseVo = new ResponseVo();
        int i = taskService.updateByPrimaryKeySelective(task);
        if (i > 0){
            responseVo.setMsg("OK");
            responseVo.setStatus(200);
        }else {
            responseVo.setStatus(500);
            responseVo.setMsg("ERROR");
        }
        return responseVo;
    }

    @RequestMapping("/delete_judge")
    @ResponseBody
    public String delete_judge() {
        return "";
    }

    @RequestMapping("/delete_batch")
    @ResponseBody
    public ResponseVo delete_batch(String[] ids) {
        ResponseVo responseVo = new ResponseVo();
        int i = taskService.deleteByIds(ids);
        if (i > 0){
            responseVo.setMsg("OK");
            responseVo.setStatus(200);
        }else {
            responseVo.setStatus(500);
            responseVo.setMsg("ERROR");
        }
        return responseVo;
    }
}
