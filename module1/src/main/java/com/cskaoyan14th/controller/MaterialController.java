package com.cskaoyan14th.controller;

import com.cskaoyan14th.bean.Material;
import com.cskaoyan14th.bean.MaterialConsume;
import com.cskaoyan14th.bean.MaterialReceive;
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
import java.util.Date;
import java.util.List;

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

    //material 备注详情更新
    @RequestMapping("material/update_note")
    @ResponseBody
    public ResponseVo<Material> materialNoteUpdate(String materialId,String note){
        ResponseVo<Material> responseVo = new ResponseVo<>();
        //编辑
        int i = materialService.updateMaterialNote(materialId,note);
        if(i==1){
            responseVo.setStatus(200);
            responseVo.setMsg("OK");
        }
        return responseVo;

    }


    //二。物料收入
    //物料收入 显示
    @RequestMapping("/materialReceive/find")
    public String materialReceiveInfoFind(HttpSession session){
        ArrayList<String> objects = new ArrayList<>();
        objects.add("materialReceive:add");
        objects.add("materialReceive:edit");
        objects.add("materialReceive:delete");
        session.setAttribute("sysPermissionList",objects);
        return "/WEB-INF/jsp/materialReceive_list";
    }

    //物料收入 显示
    @RequestMapping("/materialReceive/list")
    @ResponseBody
    public Vo<MaterialReceive> materialReceiveInfoList(int page, int rows){
        Vo<MaterialReceive> receiveVo = materialService.getMaterialReceiveVo(page, rows);
        return receiveVo;
    }


    //material receive新增检查
    @RequestMapping("/materialReceive/add_judge")
    @ResponseBody
    public ResponseVo<MaterialReceive> materialReceiveAdd_judge(){
        ResponseVo<MaterialReceive> data = new ResponseVo<>();
        return data;
    }

    //material receive新增页面弹出
    @RequestMapping("/materialReceive/add")
    public String materialReceiveAdd(){
        return "/WEB-INF/jsp/materialReceive_add";
    }



    //material receive新增数据库
    @RequestMapping("materialReceive/insert")
    @ResponseBody
    public ResponseVo<MaterialReceive> materialReceiveInsert(String receiveId, String materialId, Integer amount, Date receiveDate,String sender,String receiver,String note){
        ResponseVo<MaterialReceive> responseVo = new ResponseVo<>();
        MaterialReceive materialReceive = new MaterialReceive();
        materialReceive.setReceiveId(receiveId);
        materialReceive.setMaterialId(materialId);
        materialReceive.setAmount(amount);
        materialReceive.setNote(note);
        materialReceive.setReceiveDate(receiveDate);
        materialReceive.setReceiver(receiver);
        materialReceive.setSender(sender);
        //检查material receive在数据库中存不存在
        Boolean flag = materialService.materialReceiveIsExists(receiveId);
        if(flag){
            responseVo.setStatus(0);
            responseVo.setMsg("undefined");
            return responseVo;
        }

        int i = materialService.insertMaterialReceive(materialReceive);
        if(i==1){
            responseVo.setStatus(200);
            responseVo.setMsg("OK");
        }
        return responseVo;

    }

    //material receive编辑检查
    @RequestMapping("/materialReceive/edit_judge")
    @ResponseBody
    public ResponseVo<MaterialReceive> materialReceiveEdit_judge(){
        ResponseVo<MaterialReceive> responseVo = new ResponseVo<>();
        return responseVo;
    }

    //material receive编辑页面弹出
    @RequestMapping("/materialReceive/edit")
    public String materialReceiveEdit(){
        return "/WEB-INF/jsp/materialReceive_edit";
    }

    //material receive编辑数据库
    @RequestMapping("materialReceive/update_all")
    @ResponseBody
    public ResponseVo<MaterialReceive> materialReceiveUpdate(String receiveId, String materialId, Integer amount, Date receiveDate,String sender,String receiver,String note){
        ResponseVo<MaterialReceive> responseVo = new ResponseVo<>();
        MaterialReceive materialReceive = new MaterialReceive();
        materialReceive.setReceiveId(receiveId);
        materialReceive.setMaterialId(materialId);
        materialReceive.setAmount(amount);
        materialReceive.setNote(note);
        materialReceive.setReceiveDate(receiveDate);
        materialReceive.setReceiver(receiver);
        materialReceive.setSender(sender);
        //编辑
        int i = materialService.updateMaterialReceive(materialReceive);
        if(i==1){
            responseVo.setStatus(200);
            responseVo.setMsg("OK");
        }
        return responseVo;


    }

    //material receive删除检查
    @RequestMapping("/materialReceive/delete_judge")
    @ResponseBody
    public ResponseVo<MaterialReceive> materialReceiveDelete_judge(){
        ResponseVo<MaterialReceive> responseVo = new ResponseVo<>();
        return responseVo;
    }

    //material receive 删除 数据库
    @RequestMapping("materialReceive/delete_batch")
    @ResponseBody
    public ResponseVo<MaterialReceive> materialReceiveDelete(String[] ids){
        ResponseVo<MaterialReceive> responseVo = new ResponseVo<>();
        int i = materialService.deleteMaterialReceive(ids);
        if(i==1){
            responseVo.setStatus(200);
            responseVo.setMsg("OK");
        }
        return responseVo;
    }

    //material receive模糊查询
    //1.用receive id查
    @RequestMapping("materialReceive/search_materialReceive_by_receiveId")
    @ResponseBody
    public Vo<MaterialReceive> materialReceiveSearchByReceiveId(String searchValue,int page,int rows){
        Vo<MaterialReceive> receiveVo = materialService.selectMaterialReceiveVoByReceiveId(searchValue, page, rows);
        return receiveVo;
    }

    //2.用material id查
    @RequestMapping("materialReceive/search_materialReceive_by_materialId")
    @ResponseBody
    public Vo<MaterialReceive> materialReceiveSearchByMaterialId(String searchValue,int page,int rows){
        Vo<MaterialReceive> receiveVo = materialService.selectMaterialReceiveVoByMaterialId(searchValue, page, rows);
        return receiveVo;
    }

    //material receive备注详情更新
    @RequestMapping("materialReceive/update_note")
    @ResponseBody
    public ResponseVo<MaterialReceive> materialReceiveNoteUpdate(String receiveId,String note){
        ResponseVo<MaterialReceive> responseVo = new ResponseVo<>();
        //编辑
        int i = materialService.updateMaterialReceiveNote(receiveId,note);
        if(i==1){
            responseVo.setStatus(200);
            responseVo.setMsg("OK");
        }
        return responseVo;

    }

    //三。物料消耗
    //物料消耗 显示
    @RequestMapping("/materialConsume/find")
    public String materialConsumeInfoFind(HttpSession session){
        ArrayList<String> objects = new ArrayList<>();
        objects.add("materialConsume:add");
        objects.add("materialConsume:edit");
        objects.add("materialConsume:delete");
        session.setAttribute("sysPermissionList",objects);
        return "/WEB-INF/jsp/materialConsume_list";
    }

    //物料消耗 显示
    @RequestMapping("/materialConsume/list")
    @ResponseBody
    public Vo<MaterialConsume> materialConsumeInfoList(int page, int rows){
        Vo<MaterialConsume> receiveVo = materialService.getMaterialConsumeVo(page, rows);
        return receiveVo;
    }

    //material consume新增检查
    @RequestMapping("/materialConsume/add_judge")
    @ResponseBody
    public ResponseVo<MaterialConsume> materialConsumeAdd_judge(){
        ResponseVo<MaterialConsume> data = new ResponseVo<>();
        return data;
    }

    //material consume新增页面弹出
    @RequestMapping("/materialConsume/add")
    public String materialConsumeAdd(){
        return "/WEB-INF/jsp/materialConsume_add";
    }



    //material consume新增数据库
    @RequestMapping("materialConsume/insert")
    @ResponseBody
    public ResponseVo<MaterialConsume> materialConsumeInsert(String consumeId, String workId,String materialId, Integer consumeAmount, Date consumeDate,String sender,String receiver,String note){
        ResponseVo<MaterialConsume> responseVo = new ResponseVo<>();
        MaterialConsume materialConsume = new MaterialConsume();
        materialConsume.setConsumeAmount(consumeAmount);
        materialConsume.setConsumeDate(consumeDate);
        materialConsume.setConsumeId(consumeId);
        materialConsume.setNote(note);
        materialConsume.setReceiver(receiver);
        materialConsume.setSender(sender);
        materialConsume.setMaterialId(materialId);
        materialConsume.setWorkId(workId);
        //检查material consume在数据库中存不存在
        Boolean flag = materialService.materialConsumeIsExists(consumeId);
        if(flag){
            responseVo.setStatus(0);
            responseVo.setMsg("undefined");
            return responseVo;
        }

        int i = materialService.insertMaterialConsume(materialConsume);
        if(i==1){
            responseVo.setStatus(200);
            responseVo.setMsg("OK");
        }
        return responseVo;

    }

    //material consume编辑检查
    @RequestMapping("/materialConsume/edit_judge")
    @ResponseBody
    public ResponseVo<MaterialConsume> materialConsumeEdit_judge(){
        ResponseVo<MaterialConsume> responseVo = new ResponseVo<>();
        return responseVo;
    }

    //material consume编辑页面弹出
    @RequestMapping("/materialConsume/edit")
    public String materialConsumeEdit(){
        return "/WEB-INF/jsp/materialConsume_edit";
    }

    //material consume编辑数据库
    @RequestMapping("materialConsume/update_all")
    @ResponseBody
    public ResponseVo<MaterialConsume> materialConsumeUpdate(String consumeId, String workId,String materialId, Integer consumeAmount, Date consumeDate,String sender,String receiver,String note){
        ResponseVo<MaterialConsume> responseVo = new ResponseVo<>();
        MaterialConsume materialConsume = new MaterialConsume();
        materialConsume.setConsumeAmount(consumeAmount);
        materialConsume.setConsumeDate(consumeDate);
        materialConsume.setConsumeId(consumeId);
        materialConsume.setNote(note);
        materialConsume.setReceiver(receiver);
        materialConsume.setSender(sender);
        materialConsume.setMaterialId(materialId);
        materialConsume.setWorkId(workId);
        //编辑
        int i = materialService.updateMaterialConsume(materialConsume);
        if(i==1){
            responseVo.setStatus(200);
            responseVo.setMsg("OK");
        }
        return responseVo;


    }

    //material consume删除检查
    @RequestMapping("/materialConsume/delete_judge")
    @ResponseBody
    public ResponseVo<MaterialConsume> materialConsumeDelete_judge(){
        ResponseVo<MaterialConsume> responseVo = new ResponseVo<>();
        return responseVo;
    }

    //material consume 删除 数据库
    @RequestMapping("materialConsume/delete_batch")
    @ResponseBody
    public ResponseVo<MaterialConsume> materialConsumeDelete(String[] ids){
        ResponseVo<MaterialConsume> responseVo = new ResponseVo<>();
        int i = materialService.deleteMaterialConsume(ids);
        if(i==1){
            responseVo.setStatus(200);
            responseVo.setMsg("OK");
        }
        return responseVo;
    }

    //material consume模糊查询
    //1.用consume id查
    @RequestMapping("materialConsume/search_materialConsume_by_consumeId")
    @ResponseBody
    public Vo<MaterialConsume> materialConsumeSearchByConsumeId(String searchValue,int page,int rows){
        Vo<MaterialConsume> receiveVo = materialService.selectMaterialConsumeVoByConsumeId(searchValue, page, rows);
        return receiveVo;
    }

    //2.用work id查
    @RequestMapping("materialConsume/search_materialConsume_by_workId")
    @ResponseBody
    public Vo<MaterialConsume> materialConsumeSearchByWorkId(String searchValue,int page,int rows){
        Vo<MaterialConsume> receiveVo = materialService.selectMaterialConsumeVoByWorkId(searchValue, page, rows);
        return receiveVo;
    }

    //3.用material id查
    @RequestMapping("materialConsume/search_materialConsume_by_materialId")
    @ResponseBody
    public Vo<MaterialConsume> materialConsumeSearchByMaterialId(String searchValue,int page,int rows){
        Vo<MaterialConsume> receiveVo = materialService.selectMaterialConsumeVoByMaterialId(searchValue, page, rows);
        return receiveVo;
    }

    //material consume备注详情更新
    @RequestMapping("materialConsume/update_note")
    @ResponseBody
    public ResponseVo<MaterialConsume> materialConsumeNoteUpdate(String consumeId,String note){
        ResponseVo<MaterialConsume> responseVo = new ResponseVo<>();
        //编辑
        int i = materialService.updateMaterialConsumeNote(consumeId,note);
        if(i==1){
            responseVo.setStatus(200);
            responseVo.setMsg("OK");
        }
        return responseVo;

    }







}
