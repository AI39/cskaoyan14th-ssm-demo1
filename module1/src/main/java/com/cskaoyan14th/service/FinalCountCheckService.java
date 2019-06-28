package com.cskaoyan14th.service;


import com.cskaoyan14th.bean.FinalCountCheckVo;

import com.cskaoyan14th.vo.Vo;

/**
 * @author Yuechao Yang
 * @version 2019-06-28-11:16
 */

public interface FinalCountCheckService {
    Vo<FinalCountCheckVo> queryFinalCountLeftEmployee(int page, int rows);
}
