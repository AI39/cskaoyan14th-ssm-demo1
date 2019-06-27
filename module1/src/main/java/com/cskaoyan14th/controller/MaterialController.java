package com.cskaoyan14th.controller;

import com.cskaoyan14th.bean.Material;
import com.cskaoyan14th.bean.Page;
import com.cskaoyan14th.vo.ResponseVo;
import com.cskaoyan14th.service.MaterialService;
import com.cskaoyan14th.vo.ResponseVo;
import com.cskaoyan14th.vo.Vo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Controller
public class MaterialController {
    @Autowired
    MaterialService materialService;

    @RequestMapping("/material/find")
    public String materialInfoFind(HttpSession session){
        ArrayList<String> objects = new ArrayList<>();
        objects.add("material:add");
        objects.add("material:edit");
        objects.add("material:delete");
        session.setAttribute("sysPermissionList",objects);
        return "/WEB-INF/jsp/material_list";
    }


    @RequestMapping("/material/list")
    @ResponseBody
    public Vo<Material> materialInfoList(int page, int rows){
        Vo<Material> materialVo = materialService.getMaterialVo(page, rows);
        return materialVo;
    }


    //material新增检查
    @RequestMapping("/material/add_judge")
    @ResponseBody
    public ResponseVo<Material> materialAdd_judge(){
       ResponseVo<Material> data = new ResponseVo<>();
       return data;
    }

   //material新增页面弹出
    @RequestMapping("/material/add")
    public String materialAdd(){
        return "/WEB-INF/jsp/material_add";
    }


    //material数据库新增
    @RequestMapping("material/insert")
    @ResponseBody
    public ResponseVo<Material> materialInsert(Material material){
        ResponseVo<Material> responseVo = new ResponseVo<>();
        //检查material
        Boolean flag = materialService.materialIsExists(material.getMaterialId());
        if(flag){
            responseVo.setStatus(0);
            responseVo.setMsg("该物料编号已经存在，请更换物料编号！");
            return responseVo;
        }

        //新增
        int i = materialService.insertMaterial(material);
        if(i==1){
            responseVo.setStatus(200);
            responseVo.setMsg("OK");

        }
        return responseVo;
    }

    //编辑检查
    @RequestMapping("/material/edit_judge")
    @ResponseBody
    public ResponseVo<Material> materialEdit_judge(){
        ResponseVo<Material> responseVo = new ResponseVo<>();
        return responseVo;
    }

    //material编辑页面弹出
    @RequestMapping("/material/edit")
    public String materialEdit(){
        return "/WEB-INF/jsp/material_edit";
    }

    //material编辑数据库
    @RequestMapping("material/update_all")
    @ResponseBody
    public ResponseVo<Material> materialUpdate(Material material){
        ResponseVo<Material> responseVo = new ResponseVo<>();
        //检查material
        Boolean isUnchanged = materialService.materialIsUnchanged(material);
        if(isUnchanged){
            responseVo.setStatus(0);
            responseVo.setMsg("修改物料信息失败");
            return responseVo;
        }
        //编辑
        int i = materialService.updateMaterial(material);
        if(i==1){
            responseVo.setStatus(200);
            responseVo.setMsg("OK");
        }
        return responseVo;


    }


    //material删除检查
    @RequestMapping("/material/delete_judge")
    @ResponseBody
    public ResponseVo<Material> materialDelete_judge(){
        ResponseVo<Material> responseVo = new ResponseVo<>();
        return responseVo;
    }

    //material删除 数据库
    @RequestMapping("material/delete_batch")
    @ResponseBody
    public ResponseVo<Material> materialDelete(String[] ids){
        ResponseVo<Material> responseVo = new ResponseVo<>();
        int i = materialService.deleteMaterial(ids);
        if(i==1){
            responseVo.setStatus(200);
            responseVo.setMsg("OK");
        }
        return responseVo;
    }

    //material查找 数据库
    //1.用id 查
    @RequestMapping("material/search_material_by_materialId")
    @ResponseBody
    public Vo<Material> materialSearchById(String searchValue,int page,int rows){
        Vo<Material> materialVo = materialService.selectMaterialVoById(searchValue,page,rows);
        return materialVo;


    }

    //2.用type 查
    @RequestMapping("material/search_material_by_materialType")
    @ResponseBody
    public Vo<Material> materialSearchByType(String searchValue,int page,int rows) {
        Vo<Material> materialVo = materialService.selectMaterialVoByType(searchValue,page,rows);
        return materialVo;
    }

}
