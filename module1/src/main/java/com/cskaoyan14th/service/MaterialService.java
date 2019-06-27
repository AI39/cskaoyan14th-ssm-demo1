package com.cskaoyan14th.service;

import com.cskaoyan14th.bean.Material;
import com.cskaoyan14th.bean.Page;

public interface MaterialService {
    Page<Material> getMaterialPage(int page, int rows);
}
