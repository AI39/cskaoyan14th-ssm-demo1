package com.cskaoyan14th.service.impl;

import com.cskaoyan14th.bean.Material;
import com.cskaoyan14th.bean.MaterialExample;
import com.cskaoyan14th.bean.MaterialReceive;
import com.cskaoyan14th.bean.MaterialReceiveExample;
import com.cskaoyan14th.mapper.MaterialMapper;
import com.cskaoyan14th.mapper.MaterialReceiveMapper;
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


}
