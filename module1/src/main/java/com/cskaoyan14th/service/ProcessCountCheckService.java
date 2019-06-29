package com.cskaoyan14th.service;


import com.cskaoyan14th.bean.ProcessCountCheck;
import com.cskaoyan14th.bean.ProcessCountCheckVo;
import com.cskaoyan14th.vo.Vo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yuechao Yang
 * @version 2019-06-28-14:52
 */
public interface ProcessCountCheckService {
    Vo<ProcessCountCheck> queryProcessCountLeftEmployee(int page, int rows);

    int processCountInsert(ProcessCountCheck processCountCheck);

    int processCountUpdate(ProcessCountCheck processCountCheck);

    int deleteCountCheckByIds(List<String> ids);

    Vo<ProcessCountCheck> searchPCCheckByFCId(String searchValue, int page, int rows);

    int updateProcessCountNoteByFCId(ProcessCountCheck processCountCheck);
}
