package com.cskaoyan14th.service;

import com.cskaoyan14th.bean.FinalMeasuretCheckVo;
import com.cskaoyan14th.bean.UnqualifyApply;
import com.cskaoyan14th.vo.Vo;


/**
 * @author Yuechao Yang
 * @version 2019-06-28-11:04
 */

public interface FinalMeasureCheckService {
    Vo<FinalMeasuretCheckVo> queryFinalMeasureLeftEmployee(int page, int rows);
}
