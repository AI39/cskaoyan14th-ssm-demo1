package com.cskaoyan14th.service.impl;

import com.cskaoyan14th.bean.*;
import com.cskaoyan14th.mapper.MaterialConsumeMapper;
import com.cskaoyan14th.mapper.MaterialMapper;
import com.cskaoyan14th.mapper.MaterialReceiveMapper;
import com.cskaoyan14th.mapper.WorkMapper;
import com.cskaoyan14th.service.MaterialService;
import com.cskaoyan14th.vo.Vo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterialServiceImpl implements MaterialService {
    @Autowired
    MaterialMapper materialMapper;

    @Autowired
    MaterialReceiveMapper materialReceiveMapper;

    @Autowired
    MaterialConsumeMapper materialConsumeMapper;

    @Autowired
    WorkMapper workMapper;

    @Override
    public Vo<Material> getMaterialVo(int page, int rows) {
        PageHelper.startPage(page,rows);

        MaterialExample materialExample=new MaterialExample();
        MaterialExample.Criteria criteria = materialExample.createCriteria();
        criteria.andMaterialIdIsNotNull();
        List<Material> list = materialMapper.selectByExample(materialExample);
        PageInfo<Material> pageInfo = new PageInfo<>(list);
        Vo<Material> materialVo = new Vo<>(pageInfo.getTotal(),pageInfo.getList());
        return materialVo;

    }

    @Override
    public Boolean materialIsExists(String materialId) {
        MaterialExample materialExample = new MaterialExample();
        MaterialExample.Criteria criteria = materialExample.createCriteria();
        criteria.andMaterialIdEqualTo(materialId);
        List<Material> list = materialMapper.selectByExample(materialExample);
        if(list!=null&&list.size()!=0){
            return true;
        }
        return false;

    }

    @Override
    public Boolean materialIsUnchanged(Material material) {
        Material material1 = materialMapper.selectByPrimaryKey(material.getMaterialId());
        if(material.getMaterialType().equals(material1.getMaterialType())&&material.getRemaining().equals(material1.getRemaining())
        &&material.getStatus().equals(material1.getStatus())&&material.getNote().equals(material1.getNote())){
            return true;
        }
        return false;

    }

    @Override
    public int insertMaterial(Material material) {
        int insert = materialMapper.insert(material);
        return insert;
    }

    @Override
    public int updateMaterial(Material material) {
        int i = materialMapper.updateByPrimaryKey(material);
        return i;
    }

    @Override
    public int deleteMaterial(String[] ids) {
        int i=0;
        for (String id:ids
             ) {
            i = materialMapper.deleteByPrimaryKey(id);
        }
        return i;
    }

    @Override
    public Vo<Material> selectMaterialVoById(String id,int page,int rows) {
        PageHelper.startPage(page,rows);

        MaterialExample materialExample = new MaterialExample();
        MaterialExample.Criteria criteria = materialExample.createCriteria();
        criteria.andMaterialIdLike("%"+id+"%");
        List<Material> list = materialMapper.selectByExample(materialExample);

        PageInfo<Material> pageInfo = new PageInfo<>(list);
        Vo<Material> materialVo= new Vo<>(pageInfo.getTotal(),pageInfo.getList());
        return materialVo;
    }

    @Override
    public Vo<Material> selectMaterialVoByType(String type,int page,int rows) {
        PageHelper.startPage(page,rows);

        MaterialExample materialExample = new MaterialExample();
        MaterialExample.Criteria criteria = materialExample.createCriteria();
        criteria.andMaterialIdLike("%"+type+"%");
        List<Material> list = materialMapper.selectByExample(materialExample);

        PageInfo<Material> pageInfo = new PageInfo<>(list);
        Vo<Material> materialVo= new Vo<>(pageInfo.getTotal(),pageInfo.getList());
        return materialVo;
    }

    @Override
    public int updateMaterialNote(String materialId, String note) {
        Material material = materialMapper.selectByPrimaryKey(materialId);
        material.setNote(note);
        int i = materialMapper.updateByPrimaryKey(material);
        return i;
    }

    @Override
    public Vo<MaterialReceive> getMaterialReceiveVo(int page, int rows) {
        PageHelper.startPage(page,rows);
        List<MaterialReceive> list = materialReceiveMapper.selectMaterialReceive();

        PageInfo<MaterialReceive> pageInfo = new PageInfo<>(list);
        Vo<MaterialReceive> receiveVo = new Vo<>(pageInfo.getTotal(),pageInfo.getList());
        return receiveVo;
    }

    @Override
    public List<Material> getAllMaterial() {
        MaterialExample materialExample=new MaterialExample();
        MaterialExample.Criteria criteria = materialExample.createCriteria();
        criteria.andMaterialIdIsNotNull();
        List<Material> materials = materialMapper.selectByExample(materialExample);
        return materials;
    }

    @Override
    public Boolean materialReceiveIsExists(String materialReceiveId) {
        MaterialReceiveExample materialReceiveExample = new MaterialReceiveExample();
        MaterialReceiveExample.Criteria criteria = materialReceiveExample.createCriteria();
        criteria.andReceiveIdEqualTo(materialReceiveId);
        List<MaterialReceive> list = materialReceiveMapper.selectByExample(materialReceiveExample);
        if(list!=null&&list.size()!=0){
            return true;
        }
        return false;
    }

    @Override
    public int insertMaterialReceive(MaterialReceive materialReceive) {
        int insert = materialReceiveMapper.insert(materialReceive);
        return insert;
    }

    @Override
    public int updateMaterialReceive(MaterialReceive materialReceive) {
        int i = materialReceiveMapper.updateByPrimaryKey(materialReceive);
        return i;
    }

    @Override
    public int deleteMaterialReceive(String[] ids) {
        int i=0;
        for (String id:ids
             ) {
            i = materialReceiveMapper.deleteByPrimaryKey(id);
        }
        return i;
    }

    @Override
    public Vo<MaterialReceive> selectMaterialReceiveVoByReceiveId(String receiveid, int page, int rows) {
        PageHelper.startPage(page,rows);
        List<MaterialReceive> list = materialReceiveMapper.selectMaterialReceiveByReceiveId("%" + receiveid + "%");
        PageInfo<MaterialReceive> pageInfo = new PageInfo<>(list);
        Vo<MaterialReceive> materialReceiveVo = new Vo<>(pageInfo.getTotal(), pageInfo.getList());
        return materialReceiveVo;
    }

    @Override
    public Vo<MaterialReceive> selectMaterialReceiveVoByMaterialId(String materialid, int page, int rows) {
        PageHelper.startPage(page,rows);
        List<MaterialReceive> list = materialReceiveMapper.selectMaterialReceiveByMaterialId("%" + materialid + "%");
        PageInfo<MaterialReceive> pageInfo = new PageInfo<>(list);
        Vo<MaterialReceive> materialReceiveVo = new Vo<>(pageInfo.getTotal(), pageInfo.getList());
        return materialReceiveVo;
    }

    @Override
    public int updateMaterialReceiveNote(String receiveid, String note) {
        MaterialReceive materialReceive = materialReceiveMapper.selectByPrimaryKey(receiveid);
        materialReceive.setNote(note);
        int i = materialReceiveMapper.updateByPrimaryKey(materialReceive);
        return i;
    }

    @Override
    public Vo<MaterialConsume> getMaterialConsumeVo(int page, int rows) {
        PageHelper.startPage(page,rows);
        List<MaterialConsume> list = materialConsumeMapper.selectMaterialConsume();

        PageInfo<MaterialConsume> pageInfo = new PageInfo<>(list);
        Vo<MaterialConsume> receiveVo = new Vo<>(pageInfo.getTotal(),pageInfo.getList());
        return receiveVo;
    }

    @Override
    public List<Work> getAllWork() {
        WorkExample workExample = new WorkExample();
        WorkExample.Criteria criteria = workExample.createCriteria();
        criteria.andWorkIdIsNotNull();
        List<Work> works = workMapper.selectByExample(workExample);
        return works;
    }

    @Override
    public Boolean materialConsumeIsExists(String materialConsumeId) {
        MaterialConsumeExample materialConsumeExample = new MaterialConsumeExample();
        MaterialConsumeExample.Criteria criteria = materialConsumeExample.createCriteria();
        criteria.andConsumeIdEqualTo(materialConsumeId);
        List<MaterialConsume> list = materialConsumeMapper.selectByExample(materialConsumeExample);
        if(list!=null&&list.size()!=0){
            return true;
        }
        return false;
    }

    @Override
    public int insertMaterialConsume(MaterialConsume materialConsume) {
        int insert = materialConsumeMapper.insert(materialConsume);
        return insert;
    }

    @Override
    public int updateMaterialConsume(MaterialConsume materialConsume) {
        int i = materialConsumeMapper.updateByPrimaryKey(materialConsume);
        return i;
    }

    @Override
    public int deleteMaterialConsume(String[] ids) {
        int i=0;
        for (String id:ids
        ) {
            i = materialConsumeMapper.deleteByPrimaryKey(id);
        }
        return i;
    }

    @Override
    public Vo<MaterialConsume> selectMaterialConsumeVoByConsumeId(String consumeid, int page, int rows) {
        PageHelper.startPage(page,rows);
        List<MaterialConsume> list = materialConsumeMapper.selectMaterialConsumeByConsumeId("%" + consumeid + "%");
        PageInfo<MaterialConsume> pageInfo = new PageInfo<>(list);
        Vo<MaterialConsume> materialConsumeVo = new Vo<>(pageInfo.getTotal(), pageInfo.getList());
        return materialConsumeVo;
    }

    @Override
    public Vo<MaterialConsume> selectMaterialConsumeVoByWorkId(String workid, int page, int rows) {
        PageHelper.startPage(page,rows);
        List<MaterialConsume> list = materialConsumeMapper.selectMaterialConsumeByWorkId("%" + workid + "%");
        PageInfo<MaterialConsume> pageInfo = new PageInfo<>(list);
        Vo<MaterialConsume> materialConsumeVo = new Vo<>(pageInfo.getTotal(), pageInfo.getList());
        return materialConsumeVo;
    }

    @Override
    public Vo<MaterialConsume> selectMaterialConsumeVoByMaterialId(String materialid, int page, int rows) {
        PageHelper.startPage(page,rows);
        List<MaterialConsume> list = materialConsumeMapper.selectMaterialConsumeByMaterialId("%" + materialid + "%");
        PageInfo<MaterialConsume> pageInfo = new PageInfo<>(list);
        Vo<MaterialConsume> materialConsumeVo = new Vo<>(pageInfo.getTotal(), pageInfo.getList());
        return materialConsumeVo;
    }

    @Override
    public int updateMaterialConsumeNote(String consumeId, String note) {
        MaterialConsume materialConsume = materialConsumeMapper.selectByPrimaryKey(consumeId);
        materialConsume.setNote(note);
        int i = materialConsumeMapper.updateByPrimaryKey(materialConsume);
        return i;
    }

    @Override
    public Material selectMaterialById(String materialId) {
        Material material = materialMapper.selectByPrimaryKey(materialId);
        return material;
    }


}
