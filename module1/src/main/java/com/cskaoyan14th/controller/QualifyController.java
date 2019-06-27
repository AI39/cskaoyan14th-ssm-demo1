package com.cskaoyan14th.controller;

import com.cskaoyan14th.bean.UnqualifyApply;
import com.cskaoyan14th.bean.UnqualifyApplyExample;
import com.cskaoyan14th.mapper.FinalCountCheckMapper;
import com.cskaoyan14th.mapper.ProcessCountCheckMapper;
import com.cskaoyan14th.mapper.UnqualifyApplyMapper;
import com.cskaoyan14th.util.MyUtil;
import com.cskaoyan14th.vo.Vo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author Yuechao Yang
 * @version 2019-06-27-14:56
 */
@Controller
public class QualifyController {
    @Autowired
    UnqualifyApplyMapper unqualifyApplyMapper;
    @Autowired
    FinalCountCheckMapper finalCountCheckMapper;
    @Autowired
    ProcessCountCheckMapper processCountCheckMapper;

    @RequestMapping("unqualify/find")
    public String unqualifyFind(HttpServletRequest request){
        MyUtil.sysPermissionList(request);
        return "WEB-INF/jsp/unqualify_list";                                                                        /*这里面需要调用query写json返回*/
    }
    @RequestMapping("unqualify/list")                                                                                         /*用于数据回显，返回一个json的数据*/
    @ResponseBody
    public Vo<UnqualifyApply> unqualifyList(int page, int rows){
        PageHelper.startPage(page,rows);
        UnqualifyApplyExample unqualifyApplyExample = new UnqualifyApplyExample();
        UnqualifyApplyExample.Criteria criteria = unqualifyApplyExample.createCriteria();
        criteria.andProductIdIsNotNull();                                                                           /*这里是加了一个条件，用于不让productId为空*/
        List<UnqualifyApply> unqualifyApplyList1 = unqualifyApplyMapper.selectByExample(unqualifyApplyExample);     /*通过生成的example调用底层的mapper方法*/

        PageInfo<UnqualifyApply> pageInfo = new PageInfo<>(unqualifyApplyList1);


        Vo<UnqualifyApply> unqualifyApplyList = new Vo<>(pageInfo.getTotal(),pageInfo.getList());
        System.out.println(unqualifyApplyList);
        return unqualifyApplyList;
    }


    @RequestMapping("f_count_check/find")
    public String fCountCheckFind(HttpServletRequest request){
        MyUtil.sysPermissionList(request);
        return "WEB-INF/jsp/f_count_check_list";
    }



    @RequestMapping("measure/find")
    public String fMeasureCheckFind(HttpServletRequest request){
        MyUtil.sysPermissionList(request);
        return "WEB-INF/jsp/measurement_list";
    }


    @RequestMapping("p_count_check/find")
    public String pCountCheckFind(HttpServletRequest request){

        MyUtil.sysPermissionList(request);
        return "WEB-INF/jsp/p_count_check_list";
    }

    @RequestMapping("p_measure_check/find")
    public String pMeasureCheckFind(HttpServletRequest request){
        MyUtil.sysPermissionList(request);
        return "WEB-INF/jsp/p_measure_check_list";
    }
}
