package com.cskaoyan14th.service;

import com.cskaoyan14th.bean.Work;
import com.cskaoyan14th.vo.Vo;

public interface WorkService {
    Vo<Work> getWorkList(int page, int rows);
}
