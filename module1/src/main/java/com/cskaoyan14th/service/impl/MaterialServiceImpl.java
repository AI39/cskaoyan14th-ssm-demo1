package com.cskaoyan14th.service.impl;

import com.cskaoyan14th.bean.Material;
import com.cskaoyan14th.bean.MaterialExample;
import com.cskaoyan14th.mapper.MaterialMapper;
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


}