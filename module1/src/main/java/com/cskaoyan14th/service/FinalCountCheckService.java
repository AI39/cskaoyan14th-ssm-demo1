package com.cskaoyan14th.service;


import com.cskaoyan14th.bean.FinalCountCheck;
import com.cskaoyan14th.bean.FinalCountCheckVo;

import com.cskaoyan14th.vo.Vo;

/**
 * @author Yuechao Yang
 * @version 2019-06-28-11:16
 */

public interface FinalCountCheckService {
    Vo<FinalCountCheck> queryFinalCountLeftEmployee(int page, int rows);
}
