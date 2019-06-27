package com.cskaoyan14th.service;

import com.cskaoyan14th.bean.Manufacture;
import com.cskaoyan14th.vo.Vo;

public interface manufactureService {
    Vo<Manufacture> getManufactureList(int page, int rows);
}
