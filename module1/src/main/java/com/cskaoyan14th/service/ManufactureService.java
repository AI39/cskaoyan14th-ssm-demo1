package com.cskaoyan14th.service;

import com.cskaoyan14th.bean.Manufacture;
import com.cskaoyan14th.vo.Vo;

public interface ManufactureService {
    Vo<Manufacture> getManufactureList(int page, int rows);

    int insert(Manufacture manufacture);

    int updateByPrimaryKeySelective(Manufacture manufacture);

    int deleteByIds(String[] ids);
}