package com.cskaoyan14th.controller;

import com.cskaoyan14th.bean.*;
import com.cskaoyan14th.service.*;
import com.cskaoyan14th.vo.ResponseVo;
import com.cskaoyan14th.vo.Vo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Yuechao Yang
 * @version 2019-06-27-14:56
 */
@Controller
public class QualifyController {
    @Autowired
    UnqualifyService unqualifyService;
    @Autowired
    FinalMeasureCheckService finalMeasureCheckService;
    @Autowired
    FinalCountCheckService finalCountCheckService;
    @Autowired
    ProcessMeasureCheckService processMeasureCheckService;
    @Autowired
    ProcessCountCheckService processCountCheckService;

    /*不合格品管理*/
    @RequestMapping("unqualify/find")                                                                               /*显示增删改按钮*/
    public String unqualifyFind(HttpSession session){
        ArrayList<String> objects = new ArrayList<>();
        objects.add("unqualify:add");
        objects.add("unqualify:edit");
        objects.add("unqualify:delete");
        session.setAttribute("sysPermissionList",objects);
        return "WEB-INF/jsp/unqualify_list";                                                                        /*这里面需要调用query写json返回*/
    }

    @RequestMapping("unqualify/list")                                                                               /*用于数据回显，返回一个json的数据*/
    @ResponseBody
    public Vo<UnqualifyApply> unqualifyList(int page, int rows){

        Vo<UnqualifyApply> unqualifyApplyList = unqualifyService.queryUnqualifyApplyLeftEmployeeAndProduct(page, rows);

        return unqualifyApplyList;
    }

    @RequestMapping("unqualify/add_judge")                                                                         //unqualify新增检查
    @ResponseBody
    public ResponseVo<UnqualifyApply> unqualifyAdd_judge() {
        ResponseVo data = new ResponseVo();
        return data;                                                                                                /*通过抓包看到返回一个空的值*/
    }

    @RequestMapping("unqualify/add")                                                                                //新增页面显示
    public String unqualifyAdd() {
        return "/WEB-INF/jsp/unqualify_add";                                                                       /*跳转到新增界面*/
    }
    @RequestMapping("unqualify/insert")                                                                             //新增操作
    @ResponseBody
    public ResponseVo<UnqualifyApply> unqualifyInsert( UnqualifyApply unqualifyApply){
        ResponseVo<UnqualifyApply> responseVo = new ResponseVo<>();
        int insert = unqualifyService.unqualifyInsert(unqualifyApply);                                                   //检查主键是否冲突
        if (insert == 1){
            responseVo.setMsg("OK");
            responseVo.setStatus(200);
        }else {
            responseVo.setStatus(500);
            responseVo.setMsg("ERROR");
        }
        return responseVo;

    }

    @RequestMapping("unqualify/edit_judge")                                                                         //unqualify编辑检查
    @ResponseBody
    public ResponseVo<UnqualifyApply> unqualifyEditJudge() {
        ResponseVo data = new ResponseVo();
        return data;                                                                                                /*通过抓包看到返回一个空的值*/
    }

    @RequestMapping("unqualify/edit")                                                                                //新增编辑显示
    public String unqualifyEdit() {
        return "/WEB-INF/jsp/unqualify_edit";                                                                       /*跳转到编辑界面*/
    }

    @RequestMapping("unqualify/update_all")                                                                         /*编辑的逻辑实现*/
    @ResponseBody
    public ResponseVo unqualifyUpdateAll(UnqualifyApply unqualifyApply){
        ResponseVo responseVo = new ResponseVo();
        int update = unqualifyService.unqualifyUpdate(unqualifyApply);
        if (update == 1){
            responseVo.setMsg("OK");
            responseVo.setStatus(200);
        }else {
            responseVo.setMsg("ERROR");
            responseVo.setStatus(400);
        }
        return responseVo;
    }

    /*单独根据超链接编辑还没有实现*/


    @RequestMapping("unqualify/delete_judge")
    @ResponseBody
    public ResponseVo<UnqualifyApply> unqualifyDeleteJudge(){                                                       /*删除判断*/
        ResponseVo data = new ResponseVo();
        return data;
    }

    @RequestMapping("unqualify/delete_batch")
    @ResponseBody
    public ResponseVo<UnqualifyApply> unqualifyDeleteBatch(String[] ids){
        ResponseVo<UnqualifyApply> responseVo = new ResponseVo<>();
        ArrayList<String> list = new ArrayList<String>(Arrays.asList(ids));                                             /*这里为什么要把他转换成list*/
        int delete = unqualifyService.deleteUnqualifyByIds(list);                                                   /**/
        if (delete <= 0){
            responseVo.setStatus(400);
            responseVo.setMsg("删除失败");
        } else {
            responseVo.setMsg("OK");
            responseVo.setStatus(200);
        }
        return responseVo;
    }


    /*成品计量质检*/
    @RequestMapping("measure/find")                                                                                 /*显示增删改按钮*/
    public String fMeasureCheckFind(HttpSession session){
        ArrayList<String> objects = new ArrayList<>();
        objects.add("measure:add");
        objects.add("measure:edit");
        objects.add("measure:delete");
        session.setAttribute("sysPermissionList",objects);
        return "WEB-INF/jsp/measurement_list";
    }


    @RequestMapping("measure/list")
    @ResponseBody
    public Vo<FinalMeasuretCheckVo> finalMeasureCheckList(int page, int rows){
        Vo<FinalMeasuretCheckVo> finalMeasuretCheckList = finalMeasureCheckService.queryFinalMeasureLeftEmployee(page, rows);
        return finalMeasuretCheckList;
    }

    @RequestMapping("fMeasureCheck/add_judge")                                                                         //新增检查
    @ResponseBody
    public ResponseVo<FinalMeasuretCheckVo> fmAdd_judge() {
        ResponseVo data = new ResponseVo();
        return data;                                                                                                /*通过抓包看到返回一个空的值*/
    }

    @RequestMapping("measure/add")                                                                                //新增页面显示
    public String fmAdd() {
        return "/WEB-INF/jsp/measurement_add";
    }

    @RequestMapping("fMeasureCheck/edit_judge")                                                                         //编辑检查
    @ResponseBody
    public ResponseVo<FinalMeasuretCheckVo> fmEdit_judge() {
        ResponseVo data = new ResponseVo();
        return data;                                                                                                /*通过抓包看到返回一个空的值*/
    }

    @RequestMapping("measure/edit")                                                                                //编辑页面显示
    public String fmEdit() {
        return "/WEB-INF/jsp/measurement_edit";
    }


    /*成品计数质检*/
    @RequestMapping("f_count_check/find")                                                                           /*显示增删改按钮*/
    public String fCountCheckFind(HttpSession session){
        ArrayList<String> objects = new ArrayList<>();
        objects.add("f_count_check:add");
        objects.add("f_count_check:edit");
        objects.add("f_count_check:delete");
        session.setAttribute("sysPermissionList",objects);
        return "WEB-INF/jsp/f_count_check_list";
    }


    @RequestMapping("f_count_check/list")                                                                           /*用于数据回显，返回一个json的数据*/
    @ResponseBody
    public Vo<FinalCountCheckVo> finalCountCheckList(int page, int rows){
        Vo<FinalCountCheckVo> finalCountCheckList = finalCountCheckService.queryFinalCountLeftEmployee(page, rows);
        return  finalCountCheckList;
    }

    @RequestMapping("fCountCheck/add_judge")                                                                         //新增检查
    @ResponseBody
    public ResponseVo<FinalCountCheckVo> fcAdd_judge() {
        ResponseVo data = new ResponseVo();
        return data;                                                                                                /*通过抓包看到返回一个空的值*/
    }

    @RequestMapping("f_count_check/add")                                                                                //新增页面显示
    public String fcAdd() {
        return "/WEB-INF/jsp/f_count_check_add";
    }

    @RequestMapping("fCountCheck/edit_judge")                                                                         //编辑检查
    @ResponseBody
    public ResponseVo<FinalCountCheckVo> fcEdit_judge() {
        ResponseVo data = new ResponseVo();
        return data;                                                                                                /*通过抓包看到返回一个空的值*/
    }

    @RequestMapping("f_count_check/edit")                                                                                //编辑页面显示
    public String fcEdit() {
        return "/WEB-INF/jsp/f_count_check_edit";
    }


    /*工序计量质检*/
    @RequestMapping("p_measure_check/find")                                                                         /*显示增删改按钮*/
    public String pMeasureCheckFind(HttpSession session){
        ArrayList<String> objects = new ArrayList<>();
        objects.add("p_measure_check:add");
        objects.add("p_measure_check:edit");
        objects.add("p_measure_check:delete");
        session.setAttribute("sysPermissionList",objects);
        return "WEB-INF/jsp/p_measure_check_list";
    }

    @RequestMapping("p_measure_check/list")
    @ResponseBody
    public Vo<ProcessMeasureCheckVo> ProcessMeasureCheckList(int page, int rows){
        Vo<ProcessMeasureCheckVo> processMeasureCheckList = processMeasureCheckService.queryProcessMeasureLeftEmployee(page, rows);
        return processMeasureCheckList;
    }

    @RequestMapping("pMeasureCheck/add_judge")                                                                         //新增检查
    @ResponseBody
    public ResponseVo<ProcessMeasureCheckVo> pmAdd_judge() {
        ResponseVo data = new ResponseVo();
        return data;                                                                                                /*通过抓包看到返回一个空的值*/
    }

    @RequestMapping("p_measure_check/add")                                                                                //新增页面显示
    public String pmAdd() {
        return "/WEB-INF/jsp/p_measure_check_add";
    }

    @RequestMapping("pMeasureCheck/edit_judge")                                                                         //编辑检查
    @ResponseBody
    public ResponseVo<ProcessMeasureCheckVo> pmEdit_judge() {
        ResponseVo data = new ResponseVo();
        return data;                                                                                                /*通过抓包看到返回一个空的值*/
    }

    @RequestMapping("p_measure_check/edit")                                                                                //编辑页面显示
    public String pmEdit() {
        return "/WEB-INF/jsp/p_measure_check_edit";
    }

    /*工序计数质检*/
    @RequestMapping("p_count_check/find")                                                                           /*显示增删改按钮*/
    public String pCountCheckFind(HttpSession session){
        ArrayList<String> objects = new ArrayList<>();
        objects.add("p_count_check:add");
        objects.add("p_count_check:edit");
        objects.add("p_count_check:delete");
        session.setAttribute("sysPermissionList",objects);
        return "WEB-INF/jsp/p_count_check_list";
    }

    @RequestMapping("p_count_check/list")                                                                           /*用于数据回显，返回一个json的数据*/
    @ResponseBody
    public Vo<ProcessCountCheckVo> ProcessCountCheckList(int page, int rows){
        Vo<ProcessCountCheckVo> processCountCheckList = processCountCheckService.queryProcessCountLeftEmployee(page, rows);
        return processCountCheckList;
    }

    @RequestMapping("pCountCheck/add_judge")                                                                         //新增检查
    @ResponseBody
    public ResponseVo<ProcessCountCheckVo> pcAdd_judge() {
        ResponseVo data = new ResponseVo();
        return data;                                                                                                /*通过抓包看到返回一个空的值*/
    }

    @RequestMapping("p_count_check/add")                                                                                //新增页面显示
    public String pcAdd() {
        return "/WEB-INF/jsp/p_count_check_add";
    }

    @RequestMapping("pCountCheck/edit_judge")                                                                         //编辑检查
    @ResponseBody
    public ResponseVo<ProcessCountCheckVo> pcEdit_judge() {
        ResponseVo data = new ResponseVo();
        return data;                                                                                                /*通过抓包看到返回一个空的值*/
    }

    @RequestMapping("p_count_check/edit")                                                                                //编辑页面显示
    public String pcEdit() {
        return "/WEB-INF/jsp/p_count_check_edit";
    }
}
