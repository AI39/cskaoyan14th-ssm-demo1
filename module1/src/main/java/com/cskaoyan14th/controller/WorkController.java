package com.cskaoyan14th.controller;

import com.cskaoyan14th.bean.Work;
import com.cskaoyan14th.service.impl.WorkServiceImpl;
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
@RequestMapping("/work")
public class WorkController {
    @Autowired
    WorkServiceImpl workService;

    /*查start*/
    @RequestMapping("find")
    public ModelAndView find(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        List<String> sysPermissionList = new ToolbarButtons("work").getSysPermissionList();
        request.getSession().setAttribute("sysPermissionList",sysPermissionList);
        modelAndView.setViewName("/WEB-INF/jsp/work_list");
        return modelAndView;
    }

    @RequestMapping("list")
    @ResponseBody
    public Vo<Work> list(int page, int rows) {
        //System.out.println(workService.getWorkList(page, rows));
        return workService.getWorkList(page, rows);
    }
    /*查end*/

    /*增start*/
    @RequestMapping("add_judge")
    @ResponseBody
    public String add_judge() {
        return "";
    }

    @RequestMapping("add")
    public String add() {
        return "/WEB-INF/jsp/work_add";
    }

    @RequestMapping("insert")
    @ResponseBody
    public ResponseVo insert(Work work){
        ResponseVo responseVo = new ResponseVo();
        int i = workService.insert(work);
        if (i == -1){
            responseVo.setMsg("Id已存在");
            responseVo.setStatus(0);
        } else if (i > 0) {
            responseVo.setMsg("OK");
            responseVo.setStatus(200);
        } else {
            responseVo.setStatus(500);
            responseVo.setMsg("ERROR");
        }
        return responseVo;
    }
    /*增end*/

    /*改start*/
    @RequestMapping("edit_judge")
    @ResponseBody
    public String edit_judge() {
        return "";
    }

    @RequestMapping("edit")
    public String edit() {
        return "/WEB-INF/jsp/work_edit";
    }

    @RequestMapping("update_all")
    @ResponseBody
    public ResponseVo update_all(Work work){
        ResponseVo responseVo = new ResponseVo();
        int i = workService.updateByPrimaryKeySelective(work);
        if (i > 0){
            responseVo.setMsg("OK");
            responseVo.setStatus(200);
        }else {
            responseVo.setStatus(500);
            responseVo.setMsg("ERROR");
        }
        return responseVo;
    }
    /*改end*/

    /*删start*/
    @RequestMapping("delete_judge")
    @ResponseBody
    public String delete_judge() {
        return "";
    }

    @RequestMapping("delete_batch")
    @ResponseBody
    public ResponseVo delete_batch(String[] ids) {
        ResponseVo responseVo = new ResponseVo();
        int i = workService.deleteByIds(ids);
        if (i > 0){
            responseVo.setMsg("OK");
            responseVo.setStatus(200);
        }else {
            responseVo.setStatus(500);
            responseVo.setMsg("ERROR");
        }
        return responseVo;
    }
    /*删end*/

    /*搜索start*/
    @RequestMapping("search_work_by_workId")
    @ResponseBody
    public Vo<Work> search_work_by_workId(String searchValue, int page, int rows) {
        //System.out.println(workService.searchWorkListByWorkId(searchValue, page, rows));
        return workService.searchWorkListByWorkId(searchValue, page, rows);
    }

    @RequestMapping("search_work_by_workProduct")
    @ResponseBody
    public Vo<Work> search_work_by_workProduct(String searchValue, int page, int rows) {
        //System.out.println(workService.searchWorkListByWorkProduct(searchValue, page, rows));
        return workService.searchWorkListByWorkProduct(searchValue, page, rows);
    }

    @RequestMapping("search_work_by_workDevice")
    @ResponseBody
    public Vo<Work> search_work_by_workDevice(String searchValue, int page, int rows) {
        //System.out.println(workService.searchWorkListByWorkDevice(searchValue, page, rows));
        return workService.searchWorkListByWorkDevice(searchValue, page, rows);
    }

    @RequestMapping("search_work_by_workProcess")
    @ResponseBody
    public Vo<Work> search_work_by_workProcess(String searchValue, int page, int rows) {
        //System.out.println(workService.searchWorkListByWorkProcess(searchValue, page, rows));
        return workService.searchWorkListByWorkProcess(searchValue, page, rows);
    }

    /*搜索end*/
}
