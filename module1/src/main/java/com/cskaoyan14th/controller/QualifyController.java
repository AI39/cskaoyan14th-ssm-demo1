package com.cskaoyan14th.controller;

import com.cskaoyan14th.bean.*;
import com.cskaoyan14th.mapper.*;
import com.cskaoyan14th.service.FinalMeasureCheckService;
import com.cskaoyan14th.service.UnqualifyService;
import com.cskaoyan14th.vo.ResponseVo;
import com.cskaoyan14th.vo.Vo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Yuechao Yang
 * @version 2019-06-27-14:56
 */
@Controller
public class QualifyController {
    @Autowired
    FinalCountCheckMapper finalCountCheckMapper;
    @Autowired
    FinalMeasuretCheckMapper finalMeasuretCheckMapper;
    @Autowired
    ProcessCountCheckMapper processCountCheckMapper;
    @Autowired
    ProcessMeasureCheckMapper processMeasureCheckMapper;

    @Autowired
    UnqualifyService unqualifyService;
    @Autowired
    FinalMeasureCheckService finalMeasureCheckService;
    @Autowired

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
    public ResponseVo<DeviceType> deviceTypeAdd_judge() {
        ResponseVo data = new ResponseVo();
        return data;                                                                                                /*通过抓包看到返回一个空的值*/
    }

    @RequestMapping("unqualify/add")                                                                                //deviceType新增页面显示
    public String deviceTypeAdd() {
        return "/WEB-INF/jsp/unqualify_add";                                                                       /*跳转到新增界面*/
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
    public Vo<FinalMeasuretCheck> finalMeasureCheckList(int page, int rows){
        PageHelper.startPage(page,rows);
        FinalMeasuretCheckExample finalMeasuretCheckExample = new FinalMeasuretCheckExample();
        FinalMeasuretCheckExample.Criteria criteria = finalMeasuretCheckExample.createCriteria();
        criteria.andOrderIdIsNotNull();
        List<FinalMeasuretCheck> finalMeasureCheckList1 = finalMeasuretCheckMapper.selectByExample(finalMeasuretCheckExample);
        PageInfo<FinalMeasuretCheck> pageInfo = new PageInfo<>(finalMeasureCheckList1);
        Vo<FinalMeasuretCheck> finalMeasureCheckList = new Vo<>(pageInfo.getTotal(), pageInfo.getList());
        System.out.println(finalMeasureCheckList);
        return finalMeasureCheckList;
    }

    @RequestMapping("measure/list")
    @ResponseBody
    public Vo<FinalMeasuretCheckVo> finalMeasureCheckList(int page, int rows){
        new

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
    public Vo<FinalCountCheck> finalCountCheckList(int page, int rows){
        PageHelper.startPage(page,rows);
        FinalCountCheckExample finalCountCheckExample = new FinalCountCheckExample();
        FinalCountCheckExample.Criteria criteria = finalCountCheckExample.createCriteria();
        criteria.andOrderIdIsNotNull();                                                                             /*这里是加了一个条件，用于不让productId为空*/
        List<FinalCountCheck> finalCountCheckList1 = finalCountCheckMapper.selectByExample(finalCountCheckExample); /*通过生成的example调用底层的mapper方法*/

        PageInfo<FinalCountCheck> pageInfo = new PageInfo<>(finalCountCheckList1);


        Vo<FinalCountCheck> finalCountCheckList = new Vo<>(pageInfo.getTotal(),pageInfo.getList());
        System.out.println(finalCountCheckList);
        return finalCountCheckList;
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
    public Vo<ProcessMeasureCheck> ProcessMeasureCheckList(int page, int rows){
        PageHelper.startPage(page,rows);
        ProcessMeasureCheckExample processMeasureCheckExample = new ProcessMeasureCheckExample();
        ProcessMeasureCheckExample.Criteria criteria = processMeasureCheckExample.createCriteria();
        criteria.andProcessIdIsNotNull();
        List<ProcessMeasureCheck> processMeasureCheckList1 = processMeasureCheckMapper.selectByExample(processMeasureCheckExample);
        PageInfo<ProcessMeasureCheck> pageInfo = new PageInfo<>(processMeasureCheckList1);
        Vo<ProcessMeasureCheck> processMeasureCheckList = new Vo<>(pageInfo.getTotal(), pageInfo.getList());
        System.out.println(processMeasureCheckList);
        return processMeasureCheckList;
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
    public Vo<ProcessCountCheck> ProcessCountCheckList(int page, int rows){
        PageHelper.startPage(page,rows);
        ProcessCountCheckExample processCountCheckExample = new ProcessCountCheckExample();
        ProcessCountCheckExample.Criteria criteria = processCountCheckExample.createCriteria();
        criteria.andProcessIdIsNotNull();                                                                           /*这里是加了一个条件，用于不让productId为空*/
        List<ProcessCountCheck> processCountCheckList1 = processCountCheckMapper.selectByExample(processCountCheckExample);/*通过生成的example调用底层的mapper方法*/

        PageInfo<ProcessCountCheck> pageInfo = new PageInfo<>(processCountCheckList1);


        Vo<ProcessCountCheck> processCountCheckList = new Vo<>(pageInfo.getTotal(),pageInfo.getList());
        System.out.println(processCountCheckList);
        return processCountCheckList;
    }


}
