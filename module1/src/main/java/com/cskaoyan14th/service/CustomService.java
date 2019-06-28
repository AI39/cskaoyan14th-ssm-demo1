package com.cskaoyan14th.service;

import com.cskaoyan14th.bean.Custom;
import com.cskaoyan14th.vo.Vo;

import java.util.List;

public interface CustomService {

    List<Custom> queryCustoms();
    Custom queryCustomById(String id);

    Vo<Custom> queryCustomListPage(int page, int rows);

    int addCustom(Custom custom);

    int updateCustom(Custom custom);

    int deleteCustomsByIds(String[] ids);

    Vo<Custom> queryCustomsByCustomId(String searchValue, int page, int rows);

    Vo<Custom> queryCustomsByCustomName(String searchValue, int page, int rows);
}
