package com.cskaoyan14th.service;

import com.cskaoyan14th.bean.Material;
import com.cskaoyan14th.bean.Page;
import com.cskaoyan14th.bean.Technology;
import com.cskaoyan14th.vo.Vo;

public interface TechnologyService {
    Vo<Technology> getTechnologyVo(int page, int rows);
}
