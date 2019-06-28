package com.cskaoyan14th.service;

import com.cskaoyan14th.bean.FinalMeasuretCheck;
import com.cskaoyan14th.bean.FinalMeasuretCheckVo;
import com.cskaoyan14th.bean.UnqualifyApply;
import com.cskaoyan14th.vo.Vo;


/**
 * @author Yuechao Yang
 * @version 2019-06-28-11:04
 */

public interface FinalMeasureCheckService {
    Vo<FinalMeasuretCheck> queryFinalMeasureLeftEmployee(int page, int rows);

    int finalMseaureInsert(FinalMeasuretCheck finalMeasuretCheck);
}
