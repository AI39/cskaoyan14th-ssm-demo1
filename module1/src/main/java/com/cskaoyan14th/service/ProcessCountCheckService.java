package com.cskaoyan14th.service;


import com.cskaoyan14th.bean.ProcessCountCheck;
import com.cskaoyan14th.bean.ProcessCountCheckVo;
import com.cskaoyan14th.vo.Vo;

/**
 * @author Yuechao Yang
 * @version 2019-06-28-14:52
 */
public interface ProcessCountCheckService {
    Vo<ProcessCountCheck> queryProcessCountLeftEmployee(int page, int rows);
}
