package com.cskaoyan14th.service;

import com.cskaoyan14th.bean.Manufacture;
import com.cskaoyan14th.vo.Vo;

import java.util.List;

public interface ManufactureService {
    List<Manufacture> multiSelectAll();

    Manufacture multiSelectByManufactureSn(String id);

    Vo<Manufacture> getManufactureList(int page, int rows);

    int insert(Manufacture manufacture);

    int updateByPrimaryKeySelective(Manufacture manufacture);

    int deleteByIds(String[] ids);

    Vo<Manufacture> searchManufactureListByManufactureSn(String searchValue, int page, int rows);

    Vo<Manufacture> searchManufactureListByManufactureOrderId(String searchValue, int page, int rows);

    Vo<Manufacture> searchManufactureListByManufactureTechnologyName(String searchValue, int page, int rows);
}
