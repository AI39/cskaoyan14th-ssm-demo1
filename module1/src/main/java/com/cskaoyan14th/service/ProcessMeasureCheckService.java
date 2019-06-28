package com.cskaoyan14th.service;


import com.cskaoyan14th.bean.ProcessMeasureCheck;
import com.cskaoyan14th.bean.ProcessMeasureCheckVo;
import com.cskaoyan14th.vo.Vo;

/**
 * @author Yuechao Yang
 * @version 2019-06-28-14:53
 */
public interface ProcessMeasureCheckService {
    Vo<ProcessMeasureCheck> queryProcessMeasureLeftEmployee(int page, int rows);
}
