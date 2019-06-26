package com.cskaoyan14th.service.impl;

import com.cskaoyan14th.bean.Material;
import com.cskaoyan14th.mapper.MaterialMapper;
import com.cskaoyan14th.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterialServiceImpl implements MaterialService {
    @Autowired
    MaterialMapper materialMapper;

    @Override
    public Page<Material> getMaterialPage(int page, int rows) {
        int limit=rows;
        int offset=(page-1)*rows;
        int total = materialMapper.selectPageMaterialCount(limit, offset);
        List<Material> materials = materialMapper.selectMaterialList(limit, offset);
        Page<Material> materialPage = new Page<>();
        materialPage.setTotal(total);
        materialPage.setRows(materials);
        return materialPage;
    }
}
