package com.cskaoyan14th.service;

import com.cskaoyan14th.bean.Material;
import com.cskaoyan14th.vo.Vo;

public interface MaterialService {
    Vo<Material> getMaterialVo(int page, int rows);

    Boolean materialIsExists(String materialId);

    Boolean materialIsUnchanged(Material material);

    int insertMaterial(Material material);

    int updateMaterial(Material material);

    int deleteMaterial(String[] ids);

    Vo<Material> selectMaterialVoById(String id,int page,int rows);

    Vo<Material> selectMaterialVoByType(String type,int page,int rows);


}
