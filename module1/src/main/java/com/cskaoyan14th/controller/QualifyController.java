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

    /*不合格品管理,13个功能实现*/
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
        int insert = unqualifyService.unqualifyInsert(unqualifyApply);
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

    @RequestMapping("unqualify/delete_judge")
    @ResponseBody
    public ResponseVo<UnqualifyApply> unqualifyDeleteJudge(){                                                       /*删除判断*/
        ResponseVo data = new ResponseVo();
        return data;
    }

    @RequestMapping("unqualify/delete_batch")                                                                       /*删*/
    @ResponseBody
    public ResponseVo<UnqualifyApply> unqualifyDeleteBatch(String[] ids){
        ResponseVo<UnqualifyApply> responseVo = new ResponseVo<>();
        ArrayList<String> list = new ArrayList<String>(Arrays.asList(ids));                                             /*这里为什么要把他转换成list*/
        int delete = unqualifyService.deleteUnqualifyByIds(list);                                                   /*这里是为了使用逆向工程中的方法*/
        if (delete <= 0){
            responseVo.setStatus(400);
            responseVo.setMsg("删除失败");
        } else {
            responseVo.setMsg("OK");
            responseVo.setStatus(200);
        }
        return responseVo;
    }

    @RequestMapping("unqualify/search_unqualify_by_unqualifyId")                                                    /*要分清Vo和responseVo，Vo是封装的page对象，responseVo是封装的显示返回状态的对象*/
    @ResponseBody
    public Vo<UnqualifyApply> searchUnqualifyById(String searchValue, int page, int rows){
        Vo<UnqualifyApply> searchUnqualifyByUnqualifyId = unqualifyService.searchUnqualifyByUnqualifyId(searchValue, page, rows);
        return searchUnqualifyByUnqualifyId;

    }

    @RequestMapping("unqualify/search_unqualify_by_productName")                                                    /*需要多表查询，待修改*/
    @ResponseBody
    public Vo<UnqualifyApply> searchUnqualifyByProductName(String searchValue, int page, int rows){
        Vo<UnqualifyApply> searchUnqualifyByProductName = unqualifyService.searchUnqualifyByProductName(searchValue, page, rows);
        return searchUnqualifyByProductName;
    }

    @RequestMapping("unqualify/update_note")                                                                        /*更新备注*/
    @ResponseBody
    public ResponseVo<UnqualifyApply> UnqualifyUpdateNote(UnqualifyApply unqualifyApply){
        ResponseVo<UnqualifyApply> responseVo = new ResponseVo<>();
        int i = unqualifyService.updateUnqualifyNoteByUnqualifyId(unqualifyApply);
        if (i == 1){
            responseVo.setMsg("OK");
            responseVo.setStatus(200);
        }else {
            responseVo.setMsg("ERROR");
            responseVo.setStatus(500);
        }
        return responseVo;
    }


    /*----------------------------------------------------------------------------------------------------------------*/



    /*成品计量质检，13个方法实现*/
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
        Vo<FinalMeasuretCheck> finalMeasuretCheckList = finalMeasureCheckService.queryFinalMeasureLeftEmployee(page, rows);
        return finalMeasuretCheckList;
    }

    @RequestMapping("fMeasureCheck/add_judge")                                                                         //新增检查
    @ResponseBody
    public ResponseVo<FinalMeasuretCheck> fmAdd_judge() {
        ResponseVo data = new ResponseVo();
        return data;                                                                                                /*通过抓包看到返回一个空的值*/
    }

    @RequestMapping("measure/add")                                                                                //新增页面显示
    public String fmAdd() {
        return "/WEB-INF/jsp/measurement_add";
    }

    @RequestMapping("measure/insert")
    @ResponseBody
    public ResponseVo<FinalMeasuretCheck> measureInsert(FinalMeasuretCheck finalMeasuretCheck){
        ResponseVo<FinalMeasuretCheck> responseVo = new ResponseVo<>();
        int insert = finalMeasureCheckService.finalMseaureInsert(finalMeasuretCheck);
        if (insert == 1){
            responseVo.setMsg("OK");
            responseVo.setStatus(200);
        }else {
            responseVo.setStatus(500);
            responseVo.setMsg("ERROR");
        }
        return responseVo;
    }

    @RequestMapping("fMeasureCheck/edit_judge")                                                                         //编辑检查
    @ResponseBody
    public ResponseVo<FinalMeasuretCheck> fmEdit_judge() {
        ResponseVo data = new ResponseVo();
        return data;                                                                                                /*通过抓包看到返回一个空的值*/
    }

    @RequestMapping("measure/edit")                                                                                //编辑页面显示
    public String fmEdit() {
        return "/WEB-INF/jsp/measurement_edit";
    }

    @RequestMapping("measure/update_all")                                                                         /*编辑的逻辑实现*/
    @ResponseBody
    public ResponseVo finalMeasureUpdateAll(FinalMeasuretCheck finalMeasuretCheck){
        ResponseVo responseVo = new ResponseVo();
        int update = finalMeasureCheckService.finalMeasureUpdate(finalMeasuretCheck);
        if (update == 1){
            responseVo.setMsg("OK");
            responseVo.setStatus(200);
        }else {
            responseVo.setMsg("ERROR");
            responseVo.setStatus(400);
        }
        return responseVo;
    }

    @RequestMapping("fMeasureCheck/delete_judge")
    @ResponseBody
    public ResponseVo<FinalMeasuretCheck> fMeasureCheckDeleteJudge(){                                                       /*删除判断*/
        ResponseVo data = new ResponseVo();
        return data;
    }

    @RequestMapping("measure/delete_batch")                                                                       //删
    @ResponseBody
    public ResponseVo<FinalMeasuretCheck> finalMeasureDeleteBatch(String[] ids){
        ResponseVo<FinalMeasuretCheck> responseVo = new ResponseVo<>();
        ArrayList<String> list = new ArrayList<String>(Arrays.asList(ids));                                             //这里为什么要把他转换成list
        int delete = finalMeasureCheckService.deleteFMCheckByIds(list);                                                   //这里是为了使用逆向工程中的方法
        if (delete <= 0){
            responseVo.setStatus(400);
            responseVo.setMsg("删除失败");
        } else {
            responseVo.setMsg("OK");
            responseVo.setStatus(200);
        }
        return responseVo;
    }

    @RequestMapping("measure/search_fMeasureCheck_by_fMeasureCheckId")                                                    //要分清Vo和responseVo，Vo是封装的page对象，responseVo是封装的显示返回状态的对象
    @ResponseBody
    public Vo<FinalMeasuretCheck> searchfmCheckByCId(String searchValue, int page, int rows){
        Vo<FinalMeasuretCheck> searchUnqualifyByUnqualifyId = finalMeasureCheckService.searchfmCheckByCId(searchValue, page, rows);
        return searchUnqualifyByUnqualifyId;

    }

    @RequestMapping("measure/search_fMeasureCheck_by_orderId")                                                    //需要多表查询，待修改
    @ResponseBody
    public Vo<FinalMeasuretCheck> searchfmCheckByOId(String searchValue, int page, int rows){
        Vo<FinalMeasuretCheck> searchUnqualifyByProductName = finalMeasureCheckService.searchfmCheckByOId(searchValue, page, rows);
        return searchUnqualifyByProductName;
    }

    @RequestMapping("measure/update_note")                                                                        //更新备注
    @ResponseBody
    public ResponseVo<FinalMeasuretCheck> UnqualifyUpdateNote(FinalMeasuretCheck finalMeasuretCheck){
        ResponseVo<FinalMeasuretCheck> responseVo = new ResponseVo<>();
        int i = finalMeasureCheckService.updateFinalMeasureNoteByUnqualifyId(finalMeasuretCheck);
        if (i == 1){
            responseVo.setMsg("OK");
            responseVo.setStatus(200);
        }else {
            responseVo.setMsg("ERROR");
            responseVo.setStatus(500);
        }
        return responseVo;
    }


/*-------------------------------------------------------------------------------------------------------------------*/


    /*成品计数质检，13个方法实现*/
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
        Vo<FinalCountCheck> finalCountCheckList = finalCountCheckService.queryFinalCountLeftEmployee(page, rows);
        return  finalCountCheckList;
    }

    @RequestMapping("fCountCheck/add_judge")                                                                         //新增检查
    @ResponseBody
    public ResponseVo<FinalCountCheck> fcAdd_judge() {
        ResponseVo data = new ResponseVo();
        return data;                                                                                                /*通过抓包看到返回一个空的值*/
    }

    @RequestMapping("f_count_check/add")                                                                                //新增页面显示
    public String fcAdd() {
        return "/WEB-INF/jsp/f_count_check_add";
    }

    @RequestMapping("f_count_check/insert")
    @ResponseBody
    public ResponseVo<FinalCountCheck> finalCountCheckInsert(FinalCountCheck finalCountCheck){
        ResponseVo<FinalCountCheck> responseVo = new ResponseVo<>();
        int insert = finalCountCheckService.finalCountInsert(finalCountCheck);
        if (insert == 1){
            responseVo.setMsg("OK");
            responseVo.setStatus(200);
        }else {
            responseVo.setStatus(500);
            responseVo.setMsg("ERROR");
        }
        return responseVo;
    }


    @RequestMapping("fCountCheck/edit_judge")                                                                         //编辑检查
    @ResponseBody
    public ResponseVo<FinalCountCheck> fcEdit_judge() {
        ResponseVo data = new ResponseVo();
        return data;                                                                                                /*通过抓包看到返回一个空的值*/
    }

    @RequestMapping("f_count_check/edit")                                                                                //编辑页面显示
    public String fcEdit() {
        return "/WEB-INF/jsp/f_count_check_edit";
    }

    @RequestMapping("f_count_check/update_all")                                                                         /*编辑的逻辑实现*/
    @ResponseBody
    public ResponseVo finalCountUpdateAll(FinalCountCheck finalCountCheck){
        ResponseVo responseVo = new ResponseVo();
        int update = finalCountCheckService.finalCountUpdate(finalCountCheck);
        if (update == 1){
            responseVo.setMsg("OK");
            responseVo.setStatus(200);
        }else {
            responseVo.setMsg("ERROR");
            responseVo.setStatus(400);
        }
        return responseVo;
    }

    @RequestMapping("fCountCheck/delete_judge")
    @ResponseBody
    public ResponseVo<FinalCountCheck> fCountCheckDeleteJudge(){                                                       /*删除判断*/
        ResponseVo data = new ResponseVo();
        return data;
    }

    @RequestMapping("f_count_check/delete_batch")                                                                       //删
    @ResponseBody
    public ResponseVo<FinalCountCheck> finalCountDeleteBatch(String[] ids){
        ResponseVo<FinalCountCheck> responseVo = new ResponseVo<>();
        ArrayList<String> list = new ArrayList<String>(Arrays.asList(ids));                                             //这里为什么要把他转换成list
        int delete = finalCountCheckService.deleteCountCheckByIds(list);                                                   //这里是为了使用逆向工程中的方法
        if (delete <= 0){
            responseVo.setStatus(400);
            responseVo.setMsg("删除失败");
        } else {
            responseVo.setMsg("OK");
            responseVo.setStatus(200);
        }
        return responseVo;
    }

    @RequestMapping("f_count_check/search_fCountCheck_by_fCountCheckId")                                                    //要分清Vo和responseVo，Vo是封装的page对象，responseVo是封装的显示返回状态的对象
    @ResponseBody
    public Vo<FinalCountCheck> searchfCCheckByFCId(String searchValue, int page, int rows){
        Vo<FinalCountCheck> searchfCCheckByFCId = finalCountCheckService.searchfCCheckByFCId(searchValue, page, rows);
        return searchfCCheckByFCId;

    }

    @RequestMapping("f_count_check/search_fCountCheck_by_orderId")                                                    //需要多表查询，待修改
    @ResponseBody
    public Vo<FinalCountCheck> searchfcCheckByOId(String searchValue, int page, int rows){
        Vo<FinalCountCheck> searchfcCheckByOId = finalCountCheckService.searchfcCheckByOId(searchValue, page, rows);
        return searchfcCheckByOId;
    }

    @RequestMapping("f_count_check/update_note")                                                                        //更新备注
    @ResponseBody
    public ResponseVo<FinalCountCheck> UnqualifyUpdateNote(FinalCountCheck finalCountCheck){
        ResponseVo<FinalCountCheck> responseVo = new ResponseVo<>();
        int i = finalCountCheckService.updateFinalCountNoteByFCId(finalCountCheck);
        if (i == 1){
            responseVo.setMsg("OK");
            responseVo.setStatus(200);
        }else {
            responseVo.setMsg("ERROR");
            responseVo.setStatus(500);
        }
        return responseVo;
    }

/*--------------------------------------------------------------------------------------------------------------------------*/


    /*工序计量质检,12个方法实现*/
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
        Vo<ProcessMeasureCheck> processMeasureCheckList = processMeasureCheckService.queryProcessMeasureLeftEmployee(page, rows);
        return processMeasureCheckList;
    }

    @RequestMapping("pMeasureCheck/add_judge")                                                                         //新增检查
    @ResponseBody
    public ResponseVo<ProcessMeasureCheck> pmAdd_judge() {
        ResponseVo data = new ResponseVo();
        return data;                                                                                                /*通过抓包看到返回一个空的值*/
    }

    @RequestMapping("p_measure_check/add")                                                                                //新增页面显示
    public String pmAdd() {
        return "/WEB-INF/jsp/p_measure_check_add";
    }

    @RequestMapping("p_measure_check/insert")
    @ResponseBody
    public ResponseVo<ProcessMeasureCheck> pmInsert(ProcessMeasureCheck processMeasureCheck){
        ResponseVo<ProcessMeasureCheck> responseVo = new ResponseVo<>();
        int insert = processMeasureCheckService.processMeasureInsert(processMeasureCheck);
        if (insert == 1){
            responseVo.setMsg("OK");
            responseVo.setStatus(200);
        }else {
            responseVo.setStatus(500);
            responseVo.setMsg("ERROR");
        }
        return responseVo;
    }

    @RequestMapping("pMeasureCheck/edit_judge")                                                                         //编辑检查
    @ResponseBody
    public ResponseVo<ProcessMeasureCheck> pmEdit_judge() {
        ResponseVo data = new ResponseVo();
        return data;                                                                                                //通过抓包看到返回一个空的值
    }

    @RequestMapping("p_measure_check/edit")                                                                                //编辑页面显示
    public String pmEdit() {
        return "/WEB-INF/jsp/p_measure_check_edit";
    }

    @RequestMapping("p_measure_check/update_all")                                                                         //编辑的逻辑实现
    @ResponseBody
    public ResponseVo processMeasureUpdateAll(ProcessMeasureCheck processMeasureCheck){
        ResponseVo responseVo = new ResponseVo();
        int update = processMeasureCheckService.processMeasureUpdate(processMeasureCheck);
        if (update == 1){
            responseVo.setMsg("OK");
            responseVo.setStatus(200);
        }else {
            responseVo.setMsg("ERROR");
            responseVo.setStatus(400);
        }
        return responseVo;
    }

    @RequestMapping("pMeasureCheck/delete_judge")
    @ResponseBody
    public ResponseVo<ProcessMeasureCheck> pMeasureCheckDeleteJudge(){                                                       /*删除判断*/
        ResponseVo data = new ResponseVo();
        return data;
    }

    @RequestMapping("p_measure_check/delete_batch")                                                                       //删
    @ResponseBody
    public ResponseVo<ProcessMeasureCheck> processMeasureDeleteBatch(String[] ids){
        ResponseVo<ProcessMeasureCheck> responseVo = new ResponseVo<>();
        ArrayList<String> list = new ArrayList<String>(Arrays.asList(ids));                                             //这里为什么要把他转换成list
        int delete = processMeasureCheckService.deletePMCheckByIds(list);                                                   //这里是为了使用逆向工程中的方法
        if (delete <= 0){
            responseVo.setStatus(400);
            responseVo.setMsg("删除失败");
        } else {
            responseVo.setMsg("OK");
            responseVo.setStatus(200);
        }
        return responseVo;
    }

    @RequestMapping("p_measure_check/search_pMeasureCheck_by_pMeasureCheckId")                                                    //要分清Vo和responseVo，Vo是封装的page对象，responseVo是封装的显示返回状态的对象
    @ResponseBody
    public Vo<ProcessMeasureCheck> searchPmCheckByPId(String searchValue, int page, int rows){
        Vo<ProcessMeasureCheck> searchPmCheckBypId = processMeasureCheckService.searchPmCheckByPId(searchValue, page, rows);
        return searchPmCheckBypId;

    }


    @RequestMapping("p_measure_check/update_note")                                                                        //更新备注
    @ResponseBody
    public ResponseVo<ProcessMeasureCheck> UnqualifyUpdateNote(ProcessMeasureCheck processMeasureCheck){
        ResponseVo<ProcessMeasureCheck> responseVo = new ResponseVo<>();
        int i = processMeasureCheckService.updateProcessMeasureNoteByPMeasureId(processMeasureCheck);
        if (i == 1){
            responseVo.setMsg("OK");
            responseVo.setStatus(200);
        }else {
            responseVo.setMsg("ERROR");
            responseVo.setStatus(500);
        }
        return responseVo;
    }

/*---------------------------------------------------------------------------------------------------------------------*/

    /*工序计数质检，12个方法实现*/
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
        Vo<ProcessCountCheck> processCountCheckList = processCountCheckService.queryProcessCountLeftEmployee(page, rows);
        return processCountCheckList;
    }

    @RequestMapping("pCountCheck/add_judge")                                                                         //新增检查
    @ResponseBody
    public ResponseVo<ProcessCountCheck> pcAdd_judge() {
        ResponseVo data = new ResponseVo();
        return data;                                                                                                /*通过抓包看到返回一个空的值*/
    }

    @RequestMapping("p_count_check/add")                                                                                //新增页面显示
    public String pcAdd() {
        return "/WEB-INF/jsp/p_count_check_add";
    }

    @RequestMapping("p_count_check/insert")
    @ResponseBody
    public ResponseVo<ProcessCountCheck> processCountCheckInsert(ProcessCountCheck processCountCheck){
        ResponseVo<ProcessCountCheck> responseVo = new ResponseVo<>();
        int insert = processCountCheckService.processCountInsert(processCountCheck);
        if (insert == 1){
            responseVo.setMsg("OK");
            responseVo.setStatus(200);
        }else {
            responseVo.setStatus(500);
            responseVo.setMsg("ERROR");
        }
        return responseVo;
    }

    @RequestMapping("pCountCheck/edit_judge")                                                                         //编辑检查
    @ResponseBody
    public ResponseVo<ProcessCountCheck> pcEdit_judge() {
        ResponseVo data = new ResponseVo();
        return data;                                                                                                /*通过抓包看到返回一个空的值*/
    }

    @RequestMapping("p_count_check/edit")                                                                                //编辑页面显示
    public String pcEdit() {
        return "/WEB-INF/jsp/p_count_check_edit";
    }

    @RequestMapping("p_count_check/update_all")                                                                         /*编辑的逻辑实现*/
    @ResponseBody
    public ResponseVo processCountUpdateAll(ProcessCountCheck processCountCheck){
        ResponseVo responseVo = new ResponseVo();
        int update = processCountCheckService.processCountUpdate(processCountCheck);
        if (update == 1){
            responseVo.setMsg("OK");
            responseVo.setStatus(200);
        }else {
            responseVo.setMsg("ERROR");
            responseVo.setStatus(400);
        }
        return responseVo;
    }

    @RequestMapping("pCountCheck/delete_judge")
    @ResponseBody
    public ResponseVo<ProcessCountCheck> pCountCheckDeleteJudge(){                                                       /*删除判断*/
        ResponseVo data = new ResponseVo();
        return data;
    }

    @RequestMapping("p_count_check/delete_batch")                                                                       //删
    @ResponseBody
    public ResponseVo<ProcessCountCheck> processCountDeleteBatch(String[] ids){
        ResponseVo<ProcessCountCheck> responseVo = new ResponseVo<>();
        ArrayList<String> list = new ArrayList<String>(Arrays.asList(ids));                                             //这里为什么要把他转换成list
        int delete = processCountCheckService.deleteCountCheckByIds(list);                                                   //这里是为了使用逆向工程中的方法
        if (delete <= 0){
            responseVo.setStatus(400);
            responseVo.setMsg("删除失败");
        } else {
            responseVo.setMsg("OK");
            responseVo.setStatus(200);
        }
        return responseVo;
    }

    @RequestMapping("p_count_check/search_pCountCheck_by_pCountCheckId")                                                    //要分清Vo和responseVo，Vo是封装的page对象，responseVo是封装的显示返回状态的对象
    @ResponseBody
    public Vo<ProcessCountCheck> searchPCCheckByFCId(String searchValue, int page, int rows){
        Vo<ProcessCountCheck> searchpCCheckByFCId = processCountCheckService.searchPCCheckByFCId(searchValue, page, rows);
        return searchpCCheckByFCId;

    }


    @RequestMapping("p_count_check/update_note")                                                                        //更新备注
    @ResponseBody
    public ResponseVo<ProcessCountCheck> pcCheckUpdateNote(ProcessCountCheck processCountCheck){
        ResponseVo<ProcessCountCheck> responseVo = new ResponseVo<>();
        int i = processCountCheckService.updateProcessCountNoteByFCId(processCountCheck);
        if (i == 1){
            responseVo.setMsg("OK");
            responseVo.setStatus(200);
        }else {
            responseVo.setMsg("ERROR");
            responseVo.setStatus(500);
        }
        return responseVo;
    }
}
