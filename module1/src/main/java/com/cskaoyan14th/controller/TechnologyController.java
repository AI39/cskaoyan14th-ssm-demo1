package com.cskaoyan14th.controller;

import com.cskaoyan14th.bean.Process;
import com.cskaoyan14th.bean.Technology;
import com.cskaoyan14th.bean.TechnologyPlan;
import com.cskaoyan14th.bean.TechnologyRequirement;
import com.cskaoyan14th.bean.TechnologyRequirementShow;
import com.cskaoyan14th.service.TechnologyService;
import com.cskaoyan14th.vo.ResponseVo;
import com.cskaoyan14th.vo.Vo;
import com.sun.javafx.scene.control.skin.TreeTableRowSkin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class TechnologyController {
    @Autowired
    TechnologyService technologyService;

    // 一、工艺管理
    @RequestMapping("/technology/find")
    public String technologyManage(HttpSession session) {
        ArrayList<Object> objects = new ArrayList<>();
        objects.add("technology:add");
        objects.add("technology:edit");
        objects.add("technology:delete");
        session.setAttribute("sysPermissionList", objects);
        return "/WEB-INF/jsp/technology_list";
    }

    @RequestMapping("/technology/list")
    @ResponseBody
    public Vo<Technology> technologyList(int page, int rows) {

        Vo<Technology> technologyVo = technologyService.getTechnologyVo(page, rows);
        return technologyVo;

    }

    //technology新增检查
    @RequestMapping("/technology/add_judge")
    @ResponseBody
    public ResponseVo<Technology> technologyAdd_judge() {
        ResponseVo<Technology> ResponseVo = new ResponseVo<>();
        return ResponseVo;
    }

    //technology新增页面弹出
    @RequestMapping("/technology/add")
    public String technologyAdd() {
        return ("/WEB-INF/jsp/technology_add");
    }

    //technology数据库新增
    @RequestMapping("/technology/insert")
    @ResponseBody
    public ResponseVo<Technology> technologyInsert(Technology technology) {
        ResponseVo<Technology> responseVo = new ResponseVo<>();
        //检查technology
        boolean b = technologyService.technologyIsExists(technology.getTechnologyId());
        if (b) {
            responseVo.setStatus(0);
            responseVo.setMsg("该物料编号已经存在，请更换物料编号！");
            return responseVo;
        }
        //新增
        int i = technologyService.insertTechnology(technology);
        if (i == 1) {
            responseVo.setStatus(200);
            responseVo.setMsg("OK");

        }
        return responseVo;
    }

    //编辑检查
    @RequestMapping("/technology/edit_judge")
    @ResponseBody
    public ResponseVo<Technology> TechnologyEdit_judge() {
        ResponseVo<Technology> ResponseVo = new ResponseVo<>();
        return ResponseVo;
    }

    //technology编辑页面弹出
    @RequestMapping("/technology/edit")
    public String technologyEdit() {
        return "/WEB-INF/jsp/technology_edit";
    }

    //technology编辑数据库
    @RequestMapping("/technology/update_all")
    @ResponseBody
    public ResponseVo<Technology> technologyUpdate(Technology technology) {
        ResponseVo<Technology> responseVo = new ResponseVo<>();
        //编辑
        int i = technologyService.updateTechnology(technology);
        if (i == 1) {
            responseVo.setStatus(200);
            responseVo.setMsg("OK");
        }
        return responseVo;

    }

    //删除检查
    @RequestMapping("/technology/delete_judge")
    @ResponseBody
    public ResponseVo<Technology> TechnologyDelete_judge() {
        ResponseVo<Technology> ResponseVo = new ResponseVo<>();
        return ResponseVo;
    }

    //删除数据库
    @RequestMapping("/technology/delete_batch")
    @ResponseBody
    public ResponseVo<Technology> technologyDelete(String[] ids) {
        ResponseVo<Technology> responseVo = new ResponseVo<>();
        int i = technologyService.deleteTechnology(ids);
        if (i == 1) {
            responseVo.setStatus(200);
            responseVo.setMsg("OK");
        }
        return responseVo;
    }

    //查找数据库
    //1.用id查
    @RequestMapping("/technology/search_technology_by_technologyId")
    @ResponseBody
    public Vo<Technology> technologySearchById(String searchValue, int page, int rows) {
        Vo<Technology> technologyVo = technologyService.selectTechnologyById(searchValue, page, rows);
        return technologyVo;
    }

    //2.用type查
    @RequestMapping("/technology/search_technology_by_technologyName")
    @ResponseBody
    public Vo<Technology> technologySearchByName(String searchValue, int page, int rows) {
        Vo<Technology> technologyVo = technologyService.selectTechnologyByName(searchValue, page, rows);
        return technologyVo;
    }

    // 二、工艺要求
    //显示页面
    @RequestMapping("/technologyRequirement/find")
    public String technologyRequirement(HttpSession session) {
        ArrayList<Object> objects = new ArrayList<>();
        objects.add("technologyRequirement:add");
        objects.add("technologyRequirement:edit");
        objects.add("technologyRequirement:delete");
        session.setAttribute("sysPermissionList", objects);
        return "/WEB-INF/jsp/technologyRequirement_list";
    }

    @RequestMapping("/technologyRequirement/list")
    @ResponseBody
    public Vo<TechnologyRequirementShow> technologyRequirementList(int page, int rows) {
        Vo<TechnologyRequirementShow> requirementVo = technologyService.getTechnologyRequirementVoShow(page, rows);
        return requirementVo;
    }

    @RequestMapping("/technologyRequirement/get_data")
    @ResponseBody
    public List<Technology> getTechnologyData() {
        List<Technology> technologyList = technologyService.getAllTechnology();
        return technologyList;
    }

    //technologyRequirement新增页面弹出
    @RequestMapping("/technologyRequirement/add_judge")
    @ResponseBody
    public ResponseVo<TechnologyRequirement> technologyRequirementAdd_judge() {
        ResponseVo<TechnologyRequirement> requirementVo = new ResponseVo<>();
        return requirementVo;
    }

    //technologyRequirement数据库新增
    @RequestMapping("/technologyRequirement/add")
    public String technologyRequirementAdd() {
        return "/WEB-INF/jsp/technologyRequirement_add";
    }

    @RequestMapping("/technologyRequirement/insert")
    @ResponseBody
    public ResponseVo<TechnologyRequirement> technologyRequirementInset(TechnologyRequirement technologyRequirement) {
        ResponseVo<TechnologyRequirement> responseVo = new ResponseVo<>();
        //检查technologyrequirement
        boolean b = technologyService.technologyRequirementIsExists(technologyRequirement.getTechnologyRequirementId());
        if (b) {
            responseVo.setStatus(0);
            responseVo.setMsg("该物料编号已存在，请更换物料编号！");
            return responseVo;
        }
        //新增
        int i = technologyService.insertTechnologyRequirement(technologyRequirement);
        if (i == 1) {
            responseVo.setStatus(200);
            responseVo.setMsg("OK");
        }
        return responseVo;
    }

    //编辑检查
    @RequestMapping("/technologyRequirement/edit_judge")
    @ResponseBody
    public ResponseVo<TechnologyRequirement> technologyRequirementEdit_judge() {
        ResponseVo<TechnologyRequirement> responseVo = new ResponseVo<>();
        return responseVo;
    }

    //technologyRequirement编辑页面弹出
    @RequestMapping("/technologyRequirement/edit")
    public String technologyRequirementEdit() {
        return "/WEB-INF/jsp/technologyRequirement_edit";
    }

    //technologyRequirement编辑数据库
    @RequestMapping("/technologyRequirement/update_all")
    @ResponseBody
    public ResponseVo<TechnologyRequirement> technologyRequirementResponseUpdate(TechnologyRequirement technologyRequirement) {
        ResponseVo<TechnologyRequirement> responseVo = new ResponseVo<>();
        //编辑
        int i = technologyService.updateTechnologyRequirement(technologyRequirement);
        if (i == 1) {
            responseVo.setStatus(200);
            responseVo.setMsg("OK");
        }
        return responseVo;
    }

    //删除检查
    @RequestMapping("/technologyRequirement/delete_judge")
    @ResponseBody
    public ResponseVo<TechnologyRequirement> technologyRequirementDelete_judge() {
        ResponseVo<TechnologyRequirement> responseVo = new ResponseVo<>();
        return responseVo;
    }

    //删除数据库
    @RequestMapping("/technologyRequirement/delete_batch")
    @ResponseBody
    public ResponseVo<TechnologyRequirement> technologyRequirementDelete(String[] ids) {
        ResponseVo<TechnologyRequirement> responseVo = new ResponseVo<>();
        int i = technologyService.deleteTechnologyRequirement(ids);
        if (i == 1) {
            responseVo.setStatus(200);
            responseVo.setMsg("OK");
        }
        return responseVo;
    }
    //工艺要求
    @RequestMapping("/technologyRequirement/update_requirement")
    @ResponseBody
    public ResponseVo<TechnologyRequirement> technologyRequirementResponseUpdate_requirement(TechnologyRequirement technologyRequirement) {
        ResponseVo<TechnologyRequirement> responseVo = new ResponseVo<>();
        //编辑
        int i = technologyService.updateRequirementTechnologyRequirement(technologyRequirement);
        if (i == 1) {
            responseVo.setStatus(200);
            responseVo.setMsg("OK");
        }
        return responseVo;
    }
    //查找数据库
    //1、用id查
    @RequestMapping("/technologyRequirement/search_technologyRequirement_by_technologyRequirementId")
    @ResponseBody
    public Vo<TechnologyRequirement> technologyRequirementSearchById(String searchValue,int page,int rows){
        Vo<TechnologyRequirement> technologyVo = technologyService.selectTechnologyRequirementById(searchValue, page, rows);
        return technologyVo;
    }
    //2.用name查
    @RequestMapping("/technologyRequirement/search_technologyRequirement_by_technologyName")
    @ResponseBody
    public Vo<TechnologyRequirement> technologyRequirementSearchByName(String searchValue,int page,int rows){
        Vo<TechnologyRequirement> technologyVo = technologyService.selectTechnologyRequirementByName(searchValue, page, rows);
        return technologyVo;
    }

    // 三、工艺计划
    //显示页面
    @RequestMapping("/technologyPlan/find")
    public String technologyPlan(HttpSession session) {
        ArrayList<Object> objects = new ArrayList<>();
        objects.add("technologyPlan:add");
        objects.add("technologyPlan:edit");
        objects.add("technologyPlan:delete");
        session.setAttribute("sysPermissionList", objects);
        return "/WEB-INF/jsp/technologyPlan_list";
    }
    @RequestMapping("/technologyPlan/list")
    @ResponseBody
    public Vo<TechnologyPlan> technologyPlanList(int page, int rows) {
        Vo<TechnologyPlan> requirementVo = technologyService.getTechonologyPlanVo(page, rows);
        return requirementVo;
    }
    //
    @RequestMapping("/technologyPlan/add_judge")
    @ResponseBody
    public ResponseVo<TechnologyPlan> technologyPlanAdd_judge(){
        ResponseVo<TechnologyPlan> responseVo = new ResponseVo<>();
        return responseVo;

    }
    @RequestMapping("/technologyPlan/add")
    public String technologyPlanAdd(){

        return "/WEB-INF/jsp/technologyPlan_add";
    }

    @RequestMapping("/technologyPlan/insert")
    @ResponseBody
    public ResponseVo<TechnologyPlan> technologyPlanInset(TechnologyPlan technologyPlan) {
        ResponseVo<TechnologyPlan> responseVo = new ResponseVo<>();
        //检查technologyrequirement
        boolean b = technologyService.technologyPlanIsExists(technologyPlan.getTechnologyPlanId());
        if (b) {
            responseVo.setStatus(0);
            responseVo.setMsg("该物料编号已存在，请更换物料编号！");
            return responseVo;
        }
        //新增
        int i = technologyService.insertTechnologyPlan(technologyPlan);
        if (i == 1) {
            responseVo.setStatus(200);
            responseVo.setMsg("OK");
        }
        return responseVo;
    }

    //编辑检查
    @RequestMapping("/technologyPlan/edit_judge")
    @ResponseBody
    public ResponseVo<TechnologyPlan> technologyPlanEdit_judge() {
        ResponseVo<TechnologyPlan> responseVo = new ResponseVo<>();
        return responseVo;
    }

    //technologyRequirement编辑页面弹出
    @RequestMapping("/technologyPlan/edit")
    public String technologyPlanEdit() {
        return "/WEB-INF/jsp/technologyPlan_edit";
    }

    //technologyRequirement编辑数据库
    @RequestMapping("/technologyPlan/update_all")
    @ResponseBody
    public ResponseVo<TechnologyPlan> technologyRequirementPlanUpdate(TechnologyPlan technologyPlan) {
        ResponseVo<TechnologyPlan> responseVo = new ResponseVo<>();
        //编辑
        int i = technologyService.updateTechnologyPlan(technologyPlan);
        if (i == 1) {
            responseVo.setStatus(200);
            responseVo.setMsg("OK");
        }
        return responseVo;
    }

    //删除检查
    @RequestMapping("/technologyPlan/delete_judge")
    @ResponseBody
    public ResponseVo<TechnologyPlan> technologyPlanDelete_judge() {
        ResponseVo<TechnologyPlan> responseVo = new ResponseVo<>();
        return responseVo;
    }

    //删除数据库
    @RequestMapping("/technologyPlan/delete_batch")
    @ResponseBody
    public ResponseVo<TechnologyPlan> technologyPlanDelete(String[] ids) {
        ResponseVo<TechnologyPlan> responseVo = new ResponseVo<>();
        int i = technologyService.deleteTechnologyPlan(ids);
        if (i == 1) {
            responseVo.setStatus(200);
            responseVo.setMsg("OK");
        }
        return responseVo;
    }
    //查找数据库
    //1、用id查
    @RequestMapping("/technologyPlan/search_technologyPlan_by_technologyPlanId")
    @ResponseBody
    public Vo<TechnologyPlan> technologyPlanSearchById(String searchValue,int page,int rows){
        Vo<TechnologyPlan> technologyVo = technologyService.selectTechnologyPlanById(searchValue, page, rows);
        return technologyVo;
    }
    //2.用name查
    @RequestMapping("/technologyPlan/search_technologyPlan_by_technologyName")
    @ResponseBody
    public Vo<TechnologyPlan> technologyPlanSearchByName(String searchValue,int page,int rows){
        Vo<TechnologyPlan> technologyVo = technologyService.selectTechnologyPlanBy(searchValue, page, rows);
        return technologyVo;
    }

   // 四、工序管理
   //显示页面
   @RequestMapping("/process/find")
   public String processFind(HttpSession session) {
       ArrayList<Object> objects = new ArrayList<>();
       objects.add("process:add");
       objects.add("process:edit");
       objects.add("process:delete");
       session.setAttribute("sysPermissionList", objects);
       return "/WEB-INF/jsp/process_list";
   }
    @RequestMapping("/process/list")
    @ResponseBody
   /* public Vo<Process> processList(int page, int rows) {
        Vo<com.cskaoyan14th.bean.Process> processVo = technologyService.getProcessVo(page, rows);
        return processVo;
    }*/
   public Vo<Process> processList(int page, int rows) {
       Vo<Process>  processVo = technologyService.getProcessVo(page, rows);
        return processVo;
    }
    @RequestMapping("/process/add_judge")
    @ResponseBody
    public ResponseVo<Process> processAdd_judge(){
        ResponseVo<Process> responseVo = new ResponseVo<>();
        return responseVo;
    }
    @RequestMapping("/process/add")
    public String processAdd(){
       return "/WEB-INF/jsp/process_add";
    }
    @RequestMapping("/process/insert")
    @ResponseBody
    public ResponseVo<Process> processInsert(Process process){
        ResponseVo<Process> responseVo = new ResponseVo<>();
        boolean b = technologyService.ProcessIsExists(process.getProcessId());
        if(b){
            responseVo.setStatus(0);
            responseVo.setMsg("该物料编号已存在，请更换物料编号！");
            return responseVo;
        }
        //新增
        int i = technologyService.insertProcess(process);
        if (i == 1) {
            responseVo.setStatus(200);
            responseVo.setMsg("OK");
        }
        return responseVo;
    }
    @RequestMapping("/process/edit_judge")
    @ResponseBody
    public ResponseVo<Process> processEdit_judge(Process process) {
        ResponseVo<Process> responseVo = new ResponseVo<>();
        return responseVo;
    }
    @RequestMapping("/process/edit")
    public String processEdit(){
       return "/WEB-INF/jsp/process_edit";
    }
    @RequestMapping("/process/update_all")
    @ResponseBody
    public ResponseVo<Process> processUpdate_all(Process process){
        ResponseVo<Process> responseVo = new ResponseVo<>();
        //编辑
        int i = technologyService.updateProcess(process);
        if (i == 1) {
            responseVo.setStatus(200);
            responseVo.setMsg("OK");
        }
        return responseVo;
    }
    //删除检查
    @RequestMapping("/process/delete_judge")
    @ResponseBody
    public ResponseVo<Process> processDelete_judge(){
        ResponseVo<Process> responseVo = new ResponseVo<>();
        return responseVo;
    }
    //删除数据库
    @RequestMapping("/process/delete_batch")
    @ResponseBody
    public ResponseVo<Process> processDelete(String[] ids){
        ResponseVo<Process> responseVo = new ResponseVo<>();
        int i = technologyService.deleteProcess(ids);
        if (i == 1) {
            responseVo.setStatus(200);
            responseVo.setMsg("OK");
        }
        return responseVo;
    }

    //工艺计划编号
    @RequestMapping("/technologyPlan/get/{technologyId}")
    @ResponseBody
    public TechnologyPlan getTechnologyPlan(@PathVariable("technologyId") String technologyId){
        TechnologyPlan technologyPlan = technologyService.getTechnologyPlan(technologyId);
        return technologyPlan;
    }
//查找数据库
    //1、用id查
    @RequestMapping("/process/search_process_by_processId")
    @ResponseBody
    public Vo<Process> processSearchById(String searchValue,int page,int rows){
        Vo<Process> processVo = technologyService.selectProcessById(searchValue, page, rows);
        return processVo;
    }
    //2.用编号查
    @RequestMapping("/process/search_process_by_technologyPlanId")
    @ResponseBody
    public List<Process> processSearchByPlanId(String searchValue,int page,int rows){
        List<Process> processVo = technologyService.selectProcessByPlanId(searchValue, page, rows);
        return processVo;
    }

}
    //







