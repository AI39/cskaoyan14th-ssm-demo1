package com.cskaoyan14th.service;


import com.cskaoyan14th.bean.ProcessMeasureCheck;
import com.cskaoyan14th.bean.ProcessMeasureCheckVo;
import com.cskaoyan14th.vo.Vo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yuechao Yang
 * @version 2019-06-28-14:53
 */
public interface ProcessMeasureCheckService {
    Vo<ProcessMeasureCheck> queryProcessMeasureLeftEmployee(int page, int rows);

    int processMeasureInsert(ProcessMeasureCheck processMeasureCheck);

    int processMeasureUpdate(ProcessMeasureCheck processMeasureCheck);

    int deletePMCheckByIds(List<String> list);

    Vo<ProcessMeasureCheck> searchPmCheckByPId(String searchValue, int page, int rows);

    int updateProcessMeasureNoteByPMeasureId(ProcessMeasureCheck processMeasureCheck);
}
